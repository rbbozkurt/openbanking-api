FROM eclipse-temurin:17-jdk-jammy

# Copy JAR from Gradle output directory
COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
