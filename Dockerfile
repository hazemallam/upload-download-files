FROM openjdk:21
VOLUME /tmp
COPY build/libs/upload-download-files-0.0.1-SNAPSHOT.jar upload-download-files-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/upload-download-files-0.0.1-SNAPSHOT.jar"]
