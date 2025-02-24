import { Kafka, Consumer } from "kafkajs";
import { AppDataSource } from "./data-source";
import { Cuenta } from "./entity/Cuenta";
import { Consumo } from "./entity/Consumo";
import "reflect-metadata";

interface DebeziumMessage<T> {
  op: "c" | "u" | "d"; // Operación: create, update, delete
  after: T; // Datos después de la operación
  before: T; // Datos antes de la operación (solo para delete)
}

const kafka = new Kafka({
  clientId: "kafka-consumer",
  brokers: [process.env.KAFKA_BROKER || "kafka:9092"],
});

const consumer = kafka.consumer({ groupId: "cdc-group" });

// Método para procesar mensajes de la tabla "cuenta"
async function processCuentaMessage(value: DebeziumMessage<Cuenta>) {
  const repository = AppDataSource.getRepository(Cuenta);

  if (value.op === "c" || value.op === "u") {
    const entityData = repository.create({
      ...value.after,
      fechaCreacion: new Date(value.after.fechaCreacion), // Convertir fechas
    });
    await repository.save(entityData);
    console.log("Cuenta guardada/actualizada:", entityData);
  } else if (value.op === "d") {
    await repository.delete(value.before.id);
    console.log("Cuenta eliminada:", value.before.id);
  }
}

// Método para procesar mensajes de la tabla "consumo"
async function processConsumoMessage(value: DebeziumMessage<Consumo>) {
  const repository = AppDataSource.getRepository(Consumo);

  if (value.op === "c" || value.op === "u") {
    const entityData = repository.create({
      ...value.after,
      fechaConsumo: new Date(value.after.fechaConsumo), // Convertir fechas
    });
    await repository.save(entityData);
    console.log("Consumo guardado/actualizado:", entityData);
  } else if (value.op === "d") {
    await repository.delete(value.before.id);
    console.log("Consumo eliminado:", value.before.id);
  }
}

// Función principal para ejecutar el consumer
async function run() {
  await AppDataSource.initialize();
  await consumer.connect();
  await consumer.subscribe({
    topic: "cuentasdb.public.cuenta",
    fromBeginning: true,
  });
  await consumer.subscribe({
    topic: "cuentasdb.public.consumo",
    fromBeginning: true,
  });

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      if (!message.value) {
        console.error("Received message with null value");
        return;
      }
      const value: DebeziumMessage<any> = JSON.parse(message.value.toString());

      // Determinar qué método llamar según el tópico
      if (topic === "ms-cuentas-replica-cuenta") {
        await processCuentaMessage(value);
      } else if (topic === "ms-cuentas-replica-consumo") {
        await processConsumoMessage(value);
      }
    },
  });
}

run().catch(console.error);
