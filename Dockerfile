# -------- Stage 1: Build the JAR inside container --------
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder

WORKDIR /app

# Copy only pom.xml and resolve dependencies first (for caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy all source files and build
COPY src ./src

RUN mvn clean package -DskipTests

# -------- Stage 2: Run the App --------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built JAR from previous stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
