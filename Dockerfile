FROM openjdk:8-jdk
COPY target/app.jar /usr/src/app/app.jar
CMD ["java", "-jar", "/usr/src/app/app.jar"]
