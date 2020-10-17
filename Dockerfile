FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java", "$JAVA_OPTS", "-jar", "app.jar"]