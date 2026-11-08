FROM maven:3.9-eclipse-temurin-8 AS build

WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn -q package

FROM eclipse-temurin:8-jre

WORKDIR /app
COPY --from=build /build/target/log4shell-demo-1.0.0.jar app.jar

EXPOSE 8080
CMD ["java", "-Dorg.apache.logging.log4j.level=INFO", "-jar", "app.jar"]
