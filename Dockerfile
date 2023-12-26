FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY . .

ENTRYPOINT ["java","-jar","/controller/target/controller-0.0.1-SNAPSHOT.jar"]
