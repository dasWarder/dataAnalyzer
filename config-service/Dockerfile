FROM adoptopenjdk/maven-openjdk11

MAINTAINER daswarder
COPY /. /var/mvn

RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:11-jdk-slim

ENV GIT_USERNAME=${GIT_USER}
ENV GIT_PASS=${GITHUB_ACCESS_TOKEN}
ARG PATH=target/*.jar

COPY ${PATH} /config.jar

ENTRYPOINT ["java", "-jar", "/config.jar"]