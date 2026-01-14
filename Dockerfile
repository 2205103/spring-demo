# 1️⃣ Base image: Linux + Java 21
FROM eclipse-temurin:21-jre

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy JAR into container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# 4️⃣ Expose application port
EXPOSE 8080

# 5️⃣ Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
