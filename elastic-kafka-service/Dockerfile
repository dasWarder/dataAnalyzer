FROM adoptopenjdk/maven-openjdk11

MAINTAINER daswarder
COPY /. /var/mvn
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim

ENV ZOOKEEPER_PORT='127.0.0.1:2181'
ENV ELASTIC_PORT='127.0.0.1:9200'
ENV KAFKA_PORT='127.0.0.1:9092'
ARG PATH=target/*.jar

COPY ${PATH} /elastic.jar

ENTRYPOINT ["java", "-jar", "/elastic.jar"]