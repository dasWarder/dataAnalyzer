FROM adoptopenjdk/maven-openjdk11

MAINTAINER daswarder
COPY /. /var/mvn

RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim

ARG PATH=target/*.jar
COPY ${PATH} /web-service.jar

ENTRYPOINT ["java", "-jar", "/web-service.jar"]