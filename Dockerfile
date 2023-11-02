FROM openjdk:8-jdk-alpine

EXPOSE 8089

# Copy the JAR file into the container
ADD target/achat-1.0.jar achat-1.0.jar

# Define the entry point
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
