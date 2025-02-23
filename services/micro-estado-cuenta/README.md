* Microservicio de solicitud de estado de cuenta
Este microservicio recibe una solicitud de generación de estado de cuenta y pública la solicitud en el topic "solicitar-estado-cuenta" de kafka. 

* Pre requisitos para probar el microservicio
    * Instalar docker desktop y docker compose
    * Instalar Node
    * Instalar Postman ó Insomina (o cualquier aplicativo que le permite ejecutar invocar API's)

* Como probar el servicio
    * Ubicarse en la raiz y ejecutar el comando docker compose up -d (con esto se levantará todos los componentes necesarios)
    * Ejecutar Postman o cualquier aplicativo de su elección
    * Invocar el siguiente comando curl http://localhost:26061/v1/estado-cuenta/:cuenta (debe reemplaza ":cuenta" por el identificador de cuenta de la cual se desea obtener el estado)


