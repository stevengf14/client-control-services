FROM openjdk:13
COPY "/target/people-1.0.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
