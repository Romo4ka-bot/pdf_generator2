FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
ARG JAR_FILE=client.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]