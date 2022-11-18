FROM openjdk:17-jdk-slim
RUN apt-get update && apt-get install procps -y
COPY ./spring-boot-hello-world/build/libs/spring-boot-hello-world-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "spring-boot-hello-world-0.0.1-SNAPSHOT.jar"]