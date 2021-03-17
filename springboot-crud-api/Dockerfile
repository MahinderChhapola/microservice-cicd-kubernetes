FROM openjdk:11-jdk

# Working Directory
WORKDIR /app

# Copy source code to working directory
COPY target/*.jar app.jar

# Expose port 80
EXPOSE 8080

# Run app.py at container launch
CMD ["java", "-jar", "app.jar"]
