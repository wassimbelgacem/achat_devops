FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/achat-1.0.jar achat_devops
ENTRYPOINT ["java","-jar","/achat_devops-1.0.jar"]
