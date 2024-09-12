FROM bellsoft/liberica-openjdk-17
ARG JAR_FILE=aws-project-1.0.0-SNAPSHOT.jar
COPY target/${JAR_FILE} test.jar
CMD ["java", "-jar", "test.jar"]
