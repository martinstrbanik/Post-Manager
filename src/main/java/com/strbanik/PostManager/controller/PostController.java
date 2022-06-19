package com.strbanik.PostManager.controller;

import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.exception.GenericException;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;


@RestController
@Validated
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(value = "/addPost")
    public void addPost(@Valid @RequestBody PostDto postDto) throws GenericException{
        postService.addPost(postDto);
    }

    // Request just for testing - will remove later
    @GetMapping(value = "/getAllPosts")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/getPostsByUserId/{id}")
    public List<PostDto> getPostsByUserId(@PathVariable("id")int userId){
        return postService.getPostsByUserId(userId);
    }

    @GetMapping(value = "/getPostById/{id}")
    public PostDto getPostById(@PathVariable("id") int postId) throws GenericException {
        return postService.getPostById(postId);
    }

    @DeleteMapping(value = "/deletePostById/{id}")
    public void deletePostById(@PathVariable("id")int postId) throws GenericException{
        postService.deletePost(postId);
    }

    @PutMapping(value = "/editPost/title")
    public ResponseEntity<String> editPostTitle(@RequestParam int postId, @RequestParam @NotBlank String title) throws GenericException{
        postService.editTitle(postId, title);
        return ResponseEntity.ok("jjjjjjjjjj");

    }

    @PutMapping(value = "/editPost/body")
    public void editPostBody(@RequestParam int postId, @RequestParam @NotBlank String body) throws GenericException{
        postService.editBody(postId, body);
    }
}
