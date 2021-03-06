package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.exception.GenericException;

import java.util.List;

public interface PostService {

    void addPost(PostDto postDto) throws GenericException;

    PostDto getPostById(int postId) throws GenericException;

    List<PostDto> getPostsByUserId(int userId);

    void deletePost(int postId) throws GenericException;

    void editTitle(int postId, String title) throws GenericException;

    void editBody(int postId, String body) throws GenericException;

    List<PostDto> getPostsFromExternalApi();
}
