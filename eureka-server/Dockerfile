FROM amazoncorretto:17-alpine3.20-jdk
COPY target/*.jar /home/app.jar
WORKDIR /home/
CMD java -jar app.jar