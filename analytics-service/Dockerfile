FROM adoptopenjdk/maven-openjdk11

EXPOSE 8003
MAINTAINER daswarder
COPY /. /var/mvn
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim

ENV POSTGRE_PORT='127.0.0.1:3344'
ENV ZOOKEEPER_PORT='127.0.0.1:2181'
ENV KAFKA_PORT='127.0.0.1:9092'
ARG PATH=target/*.jar
COPY ${PATH} /analytic.jar

ENTRYPOINT [ "java", "-jar", "/analytic.jar"]