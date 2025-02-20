Registrar el conector, indicando la DB de origen (MySQL o Postgres) y qué tablas/temas se van a monitorear. Por ejemplo, se puede hacer vía API REST de Debezium en http://localhost:8083/connectors.

Microservicio de réplica: Directamente configurar un conector Debezium para Postgres o MySQL.

PREGUNTA: El CDC y el microservicio de replica puede ser el mismo o no?

TAMBIEN: publicar/consumir eventos en Kafka para la lógica de negocio.

PREGUNTA: Vamos a validar el JWT solo en el Gateway-GraphQL o dentro de cada microservicio tambien?