FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/weather-spotify-microservice-1.0.jar target/app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","target/app.jar"]
