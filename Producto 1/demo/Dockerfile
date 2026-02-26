FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
# Copiamos el pom.xml y el código fuente
COPY pom.xml .
COPY src ./src
# Compilamos y generamos el .jar saltándonos los tests para ir rápido
RUN mvn clean package -DskipTests

#  Ejecución (Runtime)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copiamos solo el .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]