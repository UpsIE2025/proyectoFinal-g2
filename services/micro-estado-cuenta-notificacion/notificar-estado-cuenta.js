const { Kafka } = require('kafkajs');

const kafka = new Kafka({
  clientId: 'message-system',
  brokers: ['localhost:9092']
});

const TOPIC_SOLICITAR_ESTADO_CUENTA = 'solicitar-estado-cuenta';
const consumer = kafka.consumer({ groupId: 'message-group-estado-cuenta' });

async function processMessages() {
  await consumer.connect();
  await consumer.subscribe({ topic: TOPIC_SOLICITAR_ESTADO_CUENTA, fromBeginning: true });

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      try {
        const msg = await JSON.parse(message.value.toString());
        console.log(`notificar-estado-cuenta::processMessages - Se recibio la solicitud de generación de estado de cuenta:`, msg);         

        //TODO notificar mediante firebase "Se ha recibido una solicitud de estado cuenta. Si no reconoce la solicitud comuniquese con el banco"

      } catch (error) {
        console.error(`notificar-estado-cuenta::processMessages - Error procesando la solicitud: ${error.message}`);        
      }
    }
  });
}


// Iniciar el consumidor
processMessages().catch(console.error);
