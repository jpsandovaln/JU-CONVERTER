FROM openjdk:11
ARG JAR_FILE=build/libs/spring-boot-hello-world-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
RUN touch token.txt
RUN mkdir Uploads
RUN mkdir Download
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 5000
