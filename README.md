# Post-Manager

[![GitHub issues](https://img.shields.io/github/issues/martinstrbanik/Post-Manager)](https://github.com/martinstrbanik/Post-Manager/issues)
[![GitHub stars](https://img.shields.io/github/stars/martinstrbanik/Post-Manager)](https://github.com/martinstrbanik/Post-Manager/stargazers)
![GitHub top language](https://img.shields.io/github/languages/top/martinstrbanik/Post-Manager)

## Description

- Post-Manager is a simple project made for creating and managing posts
- Written in [Java](https://www.java.com/en/download/help/whatis_java.html) using [SpringBoot](https://spring.io/projects/spring-boot)

## Installation of the project

- Make sure you have installed [JDK 17](https://www.oracle.com/java/technologies/downloads/#jdk17-windows) and also that Java path and JAVA_HOME is set 
  correctly set in [environment variables](https://www.ibm.com/docs/en/b2b-integrator/5.2?topic=installation-setting-java-variables-in-windows)
  
- Download jar file from https://drive.google.com/file/d/1PJ9Qe45LjdxgcorbM5BfDFaJKxl2s4Sm/view?usp=sharing

- Put the jar file into your preferred directory

- Launch cmd.exe, get into the directory where the jar file is located using **cd** command
  and type following command:
>java -jar Post-Manager-0.0.1-SNAPSHOT.jar

- The application should be running now, you can head over to browser to 
  make requests

## Using the project

This project features multiple requests:


- Adding posts by passing JSON object
> http://localhost:8080/post/addPost

- Getting posts by defined userId
> http://localhost:8080/post/getPostsByUserId/{userId}

- Getting post by defined postId
> http://localhost:8080/post/getPostById/{postId}

- Deleting post by defined postId
> http://localhost:8080/post/deletePostById/{postId}

- Editing post by passing JSON object
> http://localhost:8080/post/editPost

- To open documentation
> http://localhost:8080/swagger-ui.html