FROM openjdk:17-oracle
MAINTAINER zhanibek
COPY backshop.jar my-spring-backend.jar
ENTRYPOINT ["java", "-jar", "my-spring-backend.jar"]