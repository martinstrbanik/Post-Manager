package com.strbanik.PostManager.controller;

import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.exception.GenericException;
import com.strbanik.PostManager.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(value = "/addPost")
    @ApiOperation(value = "Adds post",
            notes = "Provide JSON post class with unique id and valid userId that will be added to database"
    )
    public void addPost(@Valid @RequestBody PostDto postDto) throws GenericException{
        postService.addPost(postDto);
    }

    @GetMapping(value = "/getPostsByUserId/{id}")
    @ApiOperation(value = "Finds all posts with specified userId",
            notes = "Provide valid userId to get list of posts"
    )
    public List<PostDto> getPostsByUserId(@PathVariable("id")int userId){
        return postService.getPostsByUserId(userId);
    }

    @GetMapping(value = "/getPostById/{id}")
    @ApiOperation(value = "Finds post by specified id",
            notes = "Provide valid id to get post"
    )
    public PostDto getPostById(@PathVariable("id") int postId) throws GenericException {
        return postService.getPostById(postId);
    }

    @DeleteMapping(value = "/deletePostById/{id}")
    @ApiOperation(value = "Deletes post by specified id",
            notes = "Provide valid id to delete post"
    )
    public void deletePostById(@PathVariable("id")int postId) throws GenericException{
        postService.deletePost(postId);
    }

    @PutMapping(value = "/editPost/title")
    @ApiOperation(value = "Edits title of the post by specified id",
            notes = "Provide valid id of the post and new title"
    )
    public void editPostTitle(@RequestParam int postId, @RequestParam String title) throws GenericException{
        postService.editTitle(postId, title);

    }

    @PutMapping(value = "/editPost/body")
    @ApiOperation(value = "Edits body of the post by specified id",
            notes = "Provide valid id of the post and new body"
    )
    public void editPostBody(@RequestParam int postId, @RequestParam String body) throws GenericException{
        postService.editBody(postId, body);
    }
}
