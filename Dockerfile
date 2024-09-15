# Stage 1: Build the application
FROM gradle:7.6.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/app
WORKDIR /home/gradle/app
RUN gradle clean build -x test

# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /home/gradle/app/build/libs/qrcode-0.0.1-SNAPSHOT.jar qrcode.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "qrcode.jar"]
