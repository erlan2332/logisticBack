# Используем стабильную версию OpenJDK
FROM openjdk:23-jdk-slim

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR-файл (замени, если имя другое)
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт 8080 (добавляем, но порты маппятся в `docker-compose.yml`)
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
