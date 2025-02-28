1. Definición de servicios y mensajes en Protocol Buffers:
El archivo `src/main/proto/cuenta.proto` es la definición del contrato de servicios gRPC.
El archivo `pom.xml` es el archivo de configuración de Maven.
El archivo `src/main/java/edu/ups/ms_cuentas/services/CuentaGrpcServiceImpl.java` es el archivo de implementación del servicio gRPC.

2. Detalle de la implementación:
Este es un microservicio que implementa todas las funcionalidades para la gestión de cuentas y consumos.

Se detallan las funcionalidades implementadas:
* Modelo de Datos (JPA):
Entidades Cuenta y Consumo.

* Repositorios:
CuentaRepository y ConsumoRepository extendiendo JpaRepository.

* Servicios:
Interfaces e implementaciones para CuentaService y ConsumoService.
Lógica de negocio para CRUD de cuentas y consumos.

* gRPC:
Definición de servicios y mensajes en Protocol Buffers.
Implementación del servicio gRPC con métodos para crear y consultar.

* Configuración:
Configuración de Spring Boot para PostgreSQL.
Configuración de gRPC server.

* Docker:
Dockerfile para construir la imagen del servicio.
docker-compose.yml para orquestar el servicio y la base de datos.

3. Eliminar las clases generadas(gRPC) y el contenedor de docker si existe:
`./mvnw clean`
`docker-compose down`

4. Para ejecutar el servicio:
Primero, generar las clases de los servicios gRPC con:
`./mvnw clean generate-sources`

Después de ejecutar este comando, las clases se generarán automáticamente en `target/generated-sources/protobuf/java/edu/ups/ms_cuentas/proto/` y en `target/generated-sources/protobuf/grpc-java/edu/ups/ms_cuentas/proto/`(CuentaGrpcServiceGrpc) que luego son usadas en la implementación del servicio CuentaGrpcServiceImpl.java.

El compilador de protobuf (protoc) genera:
- Las clases de mensajes (CuentaProto, ConsumoProto, etc.)
- Las clases de request/response
- Las clases base del servicio gRPC
- Los stubs del cliente

Luego, levantar los contenedores con:
`docker-compose up -d --build`

El servicio está disponible en:

gRPC: localhost:9090

- Estructura de directorios:
ms-cuentas/
├── src/
│   └── main/
│       ├── java/
│       │   └── edu/
│       │       └── ups/
│       │           └── ms_cuentas/
│       │               ├── entities/
│       │               ├── repositories/
│       │               ├── services/
│       │               └── MsCuentasApplication.java
│       ├── proto/
│       │   └── cuenta.proto
│       └── resources/
│           └── application.properties
├── .mvn/
├── mvnw
├── mvnw.cmd
└── pom.xml

