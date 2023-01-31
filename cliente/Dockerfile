FROM openjdk:17-jdk-slim
ADD target/rompi-client-api-docker.jar rompi-client-api-docker.jar
EXPOSE 8080
ENV TZ America/Sao_Paulo
ENTRYPOINT ["java","-jar","rompi-client-api-docker.jar"]
