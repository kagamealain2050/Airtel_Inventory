# Use Java 17 (matches your pom.xml)
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy built JAR into container
COPY target/inventory-system-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will override with $PORT)
EXPOSE 8083

# Run the application
ENTRYPOINT ["java","-jar","/app/app.jar"]
