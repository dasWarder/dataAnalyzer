FROM adoptopenjdk/maven-openjdk11

MAINTAINER daswarder
COPY /. /var/maven

RUN mvn clean intsall -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim

ENV ZOOKEEPER_PORT='127.0.0.1:2181'
ENV KAFKA_PORT='127.0.0.1:9092'
ARG PATH=target/*.jar
COPY ${PATH} /web-data.jar

ENTRYPOINT ["java", "-jar", "/web-data.jar"]

