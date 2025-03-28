FROM amazoncorretto:17-alpine3.20-jdk
COPY target/*.jar /home/app.jar
WORKDIR /home/
ENV JAVA_OPTS=""
CMD java $JAVA_OPTS -jar app.jar