# Backend (Spring Boot)

## Setup (once)

1. Install JDK 21: `winget install EclipseAdoptium.Temurin.21.JDK`
2. Set `JAVA_HOME` (JDK folder) and add `%JAVA_HOME%\bin` to `Path`. Restart VS Code.
3. Check: `java -version`

No Maven install needed: `./mvnw` (Maven wrapper) downloads it.
Use `mvnw.cmd` instead of `./mvnw` in PowerShell/CMD.

> To create the scaffold of the Spring app use https://start.spring.io/

## Commands

```bash
# Run (= IntelliJ green play button) -> http://localhost:8080
./mvnw spring-boot:run

# Run in debug mode, then attach VS Code debugger to port 5005
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

# Run tests
./mvnw test

# Build jar + run it
./mvnw clean package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

Tip: with the **Spring Boot Extension Pack**, the Spring Boot Dashboard (left sidebar) has run/debug buttons like IntelliJ.
