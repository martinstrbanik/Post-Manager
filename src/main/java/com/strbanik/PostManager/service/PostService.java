package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.model.Post;

import java.util.List;

public interface PostService {
    void addPost(Post post);
    Post getPostById(int postId);
    List<Post> getPostsByUserId(int userId);
    void deletePost(int postId);
    void editPost(int postId);
    List<PostDto> getAllPosts();
    List<Object> getPostsFromExternalApi(int userId);
}
