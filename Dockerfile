# Use an official Java runtime as a base image
FROM openjdk:17-jdk-slim

# Add a label (optional)
LABEL maintainer="divyansh"

# Add the JAR file to the container
COPY target/employee-service-0.0.1-SNAPSHOT.jar employee-service.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "employee-service.jar"]
