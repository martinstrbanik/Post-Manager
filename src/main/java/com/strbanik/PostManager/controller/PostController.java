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
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(value = "/addPost")
    public void addPost(@Valid @RequestBody Post post) throws GenericException{
        postService.addPost(post);
    }

    // Request just for testing - will remove later
    @GetMapping(value = "/getAllPosts")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/getPostsByUserId/{id}")
    public List<PostDto> getPostsByUserId(@Valid @PathVariable("id")int userId){
        return postService.getPostsByUserId(userId);
    }

    @GetMapping(value = "/getPostById/{id}")
    public PostDto getPostById(@Valid @PathVariable("id") int postId) throws GenericException {
        return postService.getPostById(postId);
    }

    @DeleteMapping(value = "/deletePostById/{id}")
    public void deletePostById(@PathVariable("id")int postId) throws GenericException{
        postService.deletePost(postId);
    }
}
