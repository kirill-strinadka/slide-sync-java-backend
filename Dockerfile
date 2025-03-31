# Этап 1: Сборка приложения
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем только pom.xml для кэширования зависимостей
COPY pom.xml .
# Загружаем зависимости (этот слой будет кэшироваться, если pom.xml не изменился)
RUN mvn dependency:go-offline -B

# Копируем исходный код
COPY src ./src

# Собираем приложение с поддержкой слоев Spring Boot
RUN mvn clean package -DskipTests

# Этап 2: Запуск приложения
FROM eclipse-temurin:21-jre AS runtime

# Устанавливаем рабочую директорию
WORKDIR /app

# Создаем непривилегированного пользователя для запуска приложения
#RUN useradd -m -u 1001 appuser
#USER appuser

# Копируем JAR-файл из этапа сборки
COPY --from=build /app/target/slide-sync-backend-0.0.1-SNAPSHOT.jar app.jar

# Указываем порт
EXPOSE 3000

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]