# define base docker image
FROM openjdk:17
LABEL maintainer="martinStrbanik"
ADD target/Post-Manager-0.0.1-SNAPSHOT.jar springboot-docker-PostManager.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-PostManager.jar"]