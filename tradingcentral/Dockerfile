# Базовый образ
FROM maven:3.8.7-openjdk-18-slim

WORKDIR /app

#COPY pom.xml ./
#COPY src/ ./src/
#RUN mvn package
#CMD ["java", "-jar", "/app/target/tradingcentral-1.0-SNAPSHOT.jar"]

COPY target/tradingcentral-1.0-SNAPSHOT.jar ./
CMD ["java", "-jar", "/app/tradingcentral-1.0-SNAPSHOT.jar"]