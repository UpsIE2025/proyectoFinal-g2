# proyectoFinal-g2
Proyecto Final grupo 2

## Arquitectura de Integración
<p align="center">
    <img src="Arquitectura.png" />
</p>

### Workflow

Demostrar: el patrón de microservicios, mensajería (Kafka), orquestación GraphQL, un ejemplo de CDC (Postgres → Microservicio de Replica → MySQL), autenticación con Auth0 y clientes (mobile con React Native y SPA) que consumen el API Gateway.

## Ejecución
Para la ejecución del proyecto se debe situar en la raiz del proyecto y ejecutar el comando docker compose up -d.

## Componentes
Todos los componentes deben ser desplegados en la red project-net

### Componente Kafka
* La configuración de kafka no es una configuración para ambiente de producción y es la siguiente:
    * Topic: data-topic
    * Puerto: 9092
    * Particiones: 1
    * Factor de replicación: 1
* Validación de Servicios
    * Validación de servicios Kafka y Zookeeper
        * Ejecutar el comando: docker ps (debe visualizar Kafka y Zookeeper).
    * Validación de topics (data-topic)
        * Ingresar a kafka con el comando: docker exec -it kafka bash
        * Ejecutar el comando: kafka-topics --list --bootstrap-server localhost:9092
* Pruebas
    * Abrir dos terminales para el counsume y el producer
    * Ingresar a kafka con el comando: docker exec -it kafka bash
    * Producer: 
        * Ejecutar el comando: kafka-console-producer --broker-list localhost:9092 --topic data-topic 
        * Escribir algunos mensajes y presionar enter después de cada uno
    * Consumer
        * Ejecutar el comando: kafka-console-consumer --bootstrap-server localhost:9092 --topic data-topic --from-beginning