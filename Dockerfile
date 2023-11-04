FROM openjdk:11-jdk-slim
EXPOSE 8082
ADD target/achat-1.0.jar achat_devops
ENTRYPOINT ["java","-jar","/achat-devops-1.0.jar"]