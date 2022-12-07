FROM openjdk:17-jdk-slim
RUN apt-get update && apt install procps -y
RUN apt-get install -y ffmpeg
RUN apt-get install -y imagemagick
RUN apt-get install -y libimage-exiftool-perl
RUN apt-get install -y tesseract-ocr && apt-get install -y libtesseract-dev

ADD tessdata /tessdata
RUN mkdir Uploads
RUN mkdir Download
COPY ./spring-boot-hello-world/build/libs/spring-boot-hello-world-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "spring-boot-hello-world-0.0.1-SNAPSHOT.jar"]