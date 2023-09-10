FROM maven:3.8.4-openjdk-11-slim AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:11-jre-slim
ARG JAR_FILE_PATH=target/*.jar
COPY ${JAR_FILE_PATH} app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
