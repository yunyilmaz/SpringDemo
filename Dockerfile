FROM openjdk:8-jdk-alpine

RUN apk add wget

ADD target/product-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080
