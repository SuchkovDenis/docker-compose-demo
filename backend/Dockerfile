# Этап 1: Сборка приложения
FROM maven:3.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Копируем pom.xml и загружаем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Копируем исходный код
COPY src ./src

# Собираем проект
RUN mvn package -DskipTests

# Этап 2: Финальный минималистичный образ
FROM eclipse-temurin:21-jre

WORKDIR /app

# Копируем собранный JAR
COPY --from=build /app/target/*.jar app.jar

# Копируем ресурсы в корневую директорию, доступную для Spring
COPY --from=build /app/src/main/resources /app/

# Открываем порт приложения
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
