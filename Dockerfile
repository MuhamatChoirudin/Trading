FROM openjdk:8-jdk-alpine

RUN mkdir /app
WORKDIR /app
EXPOSE 2070
COPY target/wallX-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","wallX-0.0.1-SNAPSHOT.jar","--spring.profiles.active=deploy"]