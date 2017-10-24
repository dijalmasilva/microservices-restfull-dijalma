FROM openjdk:8-jdk-alpine
ADD target/rest-agencia.jar app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
