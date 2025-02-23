FROM eclipse-temurin:21.0.3_9-jdk-alpine as builder
WORKDIR /app

# Instalar bash y protobuf
RUN apk add --no-cache bash protobuf protobuf-dev

COPY . .
RUN chmod +x mvnw

# Forzar la descarga del plugin gRPC y dar permisos
RUN ./mvnw clean generate-sources
RUN chmod +x /app/target/protoc-plugins/protoc-gen-grpc-java-*

# Compilación 
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21.0.3_9-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
