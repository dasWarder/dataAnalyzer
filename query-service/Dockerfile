FROM adoptopenjdk/maven-openjdk11

MAINTAINER daswarder
COPY /. /var/mvn

RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim

ENV POSTGRE_USER=user
ENV POSTGRE_PASSWORD=pass
ENV POSTGRE_PORT='127.0.0.1:3344'
ENV ELASTICSEARCH_PORT='127.0.0.1:9200'
ARG PATH=target/*.jar

COPY ${PATH} /query-service.jar

ENTRYPOINT ["java", "-jar", "/query-service.jar"]