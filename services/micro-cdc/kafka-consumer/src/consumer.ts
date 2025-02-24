import { Kafka } from "kafkajs";
import { AppDataSource } from "./data-source";
import { Cuenta } from "./entity/Cuenta";
import { Consumo } from "./entity/Consumo";
import "reflect-metadata";

// Interfaz para el mensaje Debezium
interface DebeziumMessage<T> {
  op: "c" | "u" | "d"; // Operación: create, update, delete
  after: T; // Datos después de la operación
  before: T; // Datos antes de la operación (solo para delete)
}

// Configuración de Kafka
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
      id: value.after.id,
      estado: value.after.estado,
      fecha_creacion: new Date(Number(value.after.fecha_creacion) / 1000), // Convertir microsegundos a milisegundos
      saldo: value.after.saldo,
      usuario_id: value.after.usuario_id, // Mapear "usuario_id" a "usuarioId"
    });
    console.log("Guardando cuenta:", entityData);
    await repository.save(entityData);
    console.log("Cuenta guardada correctamente.");
  } else if (value.op === "d") {
    console.log("Eliminando cuenta:", value.before.id);
    await repository.delete(value.before.id);
    console.log("Cuenta eliminada correctamente.");
  }
}

// Método para procesar mensajes de la tabla "consumo"
async function processConsumoMessage(value: DebeziumMessage<Consumo>) {
  const repository = AppDataSource.getRepository(Consumo);

  if (value.op === "c" || value.op === "u") {
    const entityData = repository.create({
      id: value.after.id,
      descripcion: value.after.descripcion,
      monto: value.after.monto,
      fecha_consumo: new Date(Number(value.after.fecha_consumo) / 1000), // Convertir microsegundos a milisegundos
      estado: value.after.estado,
      cuenta_id: value.after.cuenta_id, // Mapear "cuenta_id" a "cuentaId"
    });
    console.log("Guardando consumo:", entityData);
    await repository.save(entityData);
    console.log("Consumo guardado correctamente.");
  } else if (value.op === "d") {
    console.log("Eliminando consumo:", value.before.id);
    await repository.delete(value.before.id);
    console.log("Consumo eliminado correctamente.");
  }
}

// Función principal para ejecutar el consumer
async function run() {
  try {
    // Inicializar la conexión a MySQL
    await AppDataSource.initialize();
    console.log("Conexión a MySQL establecida correctamente.");

    // Conectar al consumer de Kafka
    await consumer.connect();
    console.log("Consumer conectado a Kafka.");

    // Suscribirse a los tópicos
    await consumer.subscribe({
      topic: "cuentasdb.public.cuentas",
      fromBeginning: true,
    });
    await consumer.subscribe({
      topic: "cuentasdb.public.consumos",
      fromBeginning: true,
    });
    console.log("Consumer suscrito a los tópicos.");

    // Procesar mensajes
    await consumer.run({
      eachMessage: async ({ topic, partition, message }) => {
        if (!message.value) {
          console.error("Received message with null value");
          return;
        }

        console.log("Mensaje recibido:", {
          topic,
          partition,
          offset: message.offset,
          value: message.value.toString(),
        });

        try {
          // Parsea el mensaje
          const messageValue = JSON.parse(message.value.toString());

          // Extrae el campo "payload"
          const payload = messageValue.payload;

          // Verifica si el payload existe
          if (!payload) {
            console.error("Payload is undefined");
            return;
          }

          // Extrae los campos del payload
          const value: DebeziumMessage<any> = {
            op: payload.op,
            after: payload.after,
            before: payload.before,
          };

          console.log("Datos procesados:", {
            op: value.op,
            after: value.after,
            before: value.before,
          });

          // Procesa el mensaje según el tópico
          if (topic === "cuentasdb.public.cuentas") {
            await processCuentaMessage(value);
          } else if (topic === "cuentasdb.public.consumos") {
            await processConsumoMessage(value);
          }
        } catch (error) {
          console.error("Error processing message:", error);
        }
      },
    });
  } catch (error) {
    console.error("Error en el consumer:", error);
  }
}

// Ejecutar el consumer
run().catch(console.error);
