FROM openjdk:8-jdk-alpine
COPY target/achat-1.0.jar .
EXPOSE 8089
ENV IMAGE_NAME="wassimbelgacem_5ds2-achat"
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
