FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

WORKDIR /javaFolder

ENTRYPOINT ["java", "-jar", "app.jar"]