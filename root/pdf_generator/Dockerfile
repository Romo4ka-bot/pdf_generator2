FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
COPY times_roman.ttf /home
ARG JAR_FILE=pdf_generator.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]