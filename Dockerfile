FROM maven:3.6.3-jdk-11 as builder
WORKDIR /app
COPY . .
RUN mvn clean package
FROM openjdk:11-jdk-slim
WORKDIR /app
ENV environment="production"
COPY --from=builder /app/target/cds-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${environment}", "/app/cds-0.0.1-SNAPSHOT.jar"]