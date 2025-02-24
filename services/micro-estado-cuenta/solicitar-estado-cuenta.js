const { Kafka } = require('kafkajs');
const express = require('express');
const app = express();

app.use(express.json());

const kafka = new Kafka({
  clientId: 'message-system',
  brokers: ['kafka:9092'] 
});

const producer = kafka.producer();
const TOPIC_SOLICITAR_ESTADO_CUENTA = 'solicitar-estado-cuenta';

async function sendMessage(topic, message) {
  await producer.connect();
  await producer.send({
    topic,
    messages: [{ value: JSON.stringify(message) }]
  });
  await producer.disconnect();
}

// Enviar el mensaje con la siguiente estructura { content: message, response: gj-reply1 }
app.get("/v1/estado-cuenta/:cuenta", async (req, res) => {  
  const { cuenta } = req.params;
  console.log(`solicitar-estado-cuenta::get - Solicitud recibidad para el numero de cuenta: ${JSON.stringify(req.params)}`)
  try {        
    await sendMessage(TOPIC_SOLICITAR_ESTADO_CUENTA, {cuenta});     
    console.log(`solicitar-estado-cuenta::get - Solicitud publicada para el numero de cuenta: ${JSON.stringify(req.params)}`)
    res.status(200).json({ success: true, message: `Solicitud de Estado de Cuenta[${cuenta}] realizada con éxito` });
  } catch (error) {
    console.error(`solicitar-estado-cuenta::get - Error al publicar la solicitud - Error: ${error.message}`)
    res.status(500).json({ success: false, error: error.message });
  }
});

app.listen(26061, () => {
  console.log('Servidor corriendo en el puerto 26061');
});

