FROM openjdk:8
WORKDIR /data/app
COPY target/*.jar springboot-app.jar
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar springboot-app.jar"]