FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /app
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/japp.jar
CMD ["java", "-jar", "/app/japp.jar"]
