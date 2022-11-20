# syntax=docker/dockerfile:1
FROM openjdk:11-jdk-slim

WORKDIR /app

COPY spring-boot-hello-world/build/libs/spring-boot-hello-world-0.0.1-SNAPSHOT.jar .
COPY token .
RUN apt update && apt install ffmpeg -y
RUN apt install tesseract-ocr -y && apt install libtesseract-dev -y
ENTRYPOINT java -jar spring-boot-hello-world-0.0.1-SNAPSHOT.jar