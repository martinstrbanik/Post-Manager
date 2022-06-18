package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.exception.GenericException;
import com.strbanik.PostManager.model.Post;

import java.util.List;

public interface PostService {

    void addPost(Post post) throws GenericException;

    PostDto getPostById(int postId) throws GenericException;

    List<PostDto> getPostsByUserId(int userId);

    void deletePost(int postId) throws GenericException;

    void editPost(int postId);

    // Method used just for testing - will remove later
    List<PostDto> getAllPosts();

    List<PostDto> getPostsFromExternalApi();
}
