# Post-Manager

[![GitHub issues](https://img.shields.io/github/issues/martinstrbanik/Post-Manager)](https://github.com/martinstrbanik/Post-Manager/issues)
[![GitHub stars](https://img.shields.io/github/stars/martinstrbanik/Post-Manager)](https://github.com/martinstrbanik/Post-Manager/stargazers)
![GitHub top language](https://img.shields.io/github/languages/top/martinstrbanik/Post-Manager)

## Description

- Post-Manager is a simple project made for creating and managing posts
- Written in [Java](https://www.java.com/en/download/help/whatis_java.html) using [SpringBoot](https://spring.io/projects/spring-boot)

## Installation of the project

1. Install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows) community version and click Get from VCS

    ![IntelliJ IDEA get from VCS](https://github.com/martinstrbanik/Post-Manager/blob/main/IntelliJ1.png)
   
2. https://github.com/martinstrbanik/Post-Manager.git copy this url, select directory and click clone

   ![IntelliJ IDEA clone](https://github.com/martinstrbanik/Post-Manager/blob/main/IntelliJ2.png)

3. Expand *src/main/java/com.strbanik.PostManager*
4. Choose **Add Configuration** on the toolbar 
5. Click Add new run configuration, choose Java Scratch

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
