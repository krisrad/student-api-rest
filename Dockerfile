FROM openjdk:11
EXPOSE 8080
COPY target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-jar", "app.jar"]