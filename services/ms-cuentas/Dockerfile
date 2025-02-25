FROM eclipse-temurin:21.0.3_9-jdk-alpine as builder
WORKDIR /app

RUN apk add --no-cache bash
COPY . .
# RUN chmod +x mvnw
# RUN ./mvnw clean generate-sources

FROM eclipse-temurin:21.0.3_9-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080 9090
ENTRYPOINT ["java", "-jar", "app.jar"]