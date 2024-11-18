# Use an official Maven image to build the spring Boot app
FROM maven:3.9.4-eclipse-temurin-21 AS build


# Set the working directory
WORKDIR /app

#Copy the pom.xml and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

#Use an official OpenJDK image to run the application
FROM openjdk:21-jdk-slim

#set the working directory
WORKDIR /app

#Copy the build JAR file from the build stage
COPY --from=build /app/target/movies-0.0.1-SNAPSHOT.jar .

#Expose port 8080
EXPOSE 8080

#Specify the command to run the application
ENTRYPOINT [ "java","-jar","/app/movies-0.0.1-SNAPSHOT.jar"]
