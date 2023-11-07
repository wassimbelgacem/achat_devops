FROM openjdk:11-jdk-slim
EXPOSE 8089
ADD target/achat_devops-1.0.jar achat_devops-1.0.jar
ENTRYPOINT [ "java" ,"-jar" , "/achat_devops-1.0.jar" ]