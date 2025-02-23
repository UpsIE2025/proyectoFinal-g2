* Microservicio de notificación de solicitud de estado de cuenta
Este microservicio recibe una solicitud de generación de estado de cuenta a traves del topic "solicitar-estado-cuenta" de kafka y envia una notificación a través de firebase a la aplicación movil

* Pre requisitos para probar el microservicio
    * Instalar docker desktop y docker compose
    * Instalar Node
    * Instalar Postman ó Insomina (o cualquier aplicativo que le permite ejecutar invocar API's)

* Como probar el servicio
    * Ubicarse en la raiz y ejecutar el comando docker compose up -d (con esto se levantará todos los componentes necesarios)
    * Ejecutar Postman o cualquier aplicativo de su elección
    * Invocar el siguiente comando curl http://localhost:26061/v1/estado-cuenta/:cuenta (debe reemplaza ":cuenta" por el identificador de cuenta de la cual se desea obtener el estado)
    * Revisar en los logs el mensaje de recepción del mensaje (desde kafka)
    * Revisar en los logs la solicitud de notificación usando firebas


