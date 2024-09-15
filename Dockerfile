FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./gradlew clean build
CMD ["java", "-jar", "build/libs/qrcode-0.0.1-SNAPSHOT.jar"]
