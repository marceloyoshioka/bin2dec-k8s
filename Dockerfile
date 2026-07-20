# ---------------------------------------------------
# ESTÁGIO 1: Build (Compilação do código com cache)
# ---------------------------------------------------
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

# 1. Copia apenas o pom.xml e baixa as dependências (cria camada de cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 2. Copia o código fonte e gera o .jar
COPY src ./src
RUN mvn clean package -DskipTests


# ---------------------------------------------------
# ESTÁGIO 2: Imagem Final (Execução leve)
# ---------------------------------------------------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia o JAR compilado do estágio anterior
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]