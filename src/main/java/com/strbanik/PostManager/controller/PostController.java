package com.strbanik.PostManager.controller;

import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.exception.GenericException;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(value = "/addPost")
    public void addPost(@Valid @RequestBody Post post){
        postService.addPost(post);
    }

    @GetMapping(value = "/getAllPosts")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/getPostsByUserId")
    public List<PostDto> getPostsByUserId(@RequestParam int userId){
        return postService.getPostsByUserId(userId);
    }

    @GetMapping(value = "/getPostById")
    public PostDto getPostById(@RequestParam int postId) throws GenericException {
        return postService.getPostById(postId);
    }
}
