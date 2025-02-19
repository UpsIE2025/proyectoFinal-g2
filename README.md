# proyectoFinal-g2
Proyecto Final grupo 2

## Ejecución
Para la ejecución del proyecto se debe ejecutar el archivo docker-compose.yml que se encuentra en la raiz del proyecto

## Componentes
Todos los componentes deben ser desplegados en la red project-net

### Kafka
* La configuración de kafka no es una configuración para ambiente de productión y es la siguiente:
    * Topic:data-topic
    * Puerto: 9092
    * Particiones: 1
    * Factor de replicación: 1
* Validación de Servicios
    * Validación de servicios
        Ejecutar el comando: docker ps (debe visualizar Kafka y Zookeeper).
    * Validación de topics (data-topic)
        Ingresar a kafka con el comando: docker exec -it kafka bash
        Ejecutar el comando: kafka-topics --list --bootstrap-server localhost:9092
* Pruebas
    Abrir dos terminales para el counsume y el producer
    Ingresar a kafka con el comando: docker exec -it kafka bash
    * Producer: 
        * Ejecutar el comando: kafka-console-producer --broker-list localhost:9092 --topic data-topic 
        * Escribir algunos mensajes y presionar enter después de cada uno
    * Consumer
        * Ejecutar el comando: kafka-console-consumer --bootstrap-server localhost:9092 --topic data-topic --from-beginning