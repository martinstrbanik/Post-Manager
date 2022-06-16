package com.strbanik.PostManager.controller;

import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class PostController {

    PostService postService;

    @PostMapping(value = "/addPost")
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @GetMapping(value = "/getAllPosts")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }
}
