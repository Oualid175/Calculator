FROM openjdk:8-alpine

RUN apk update
RUN apk add  maven
COPY pom.xml /usr/local/Calculator/pom.xml
COPY src /usr/local/Calculator/src
WORKDIR /usr/local/Calculator
RUN mvn package
CMD ["java","-cp","target/CalculatorDemo-0.0.1-SNAPSHOT.jar","Calculator.CalculatorDemo.App"]