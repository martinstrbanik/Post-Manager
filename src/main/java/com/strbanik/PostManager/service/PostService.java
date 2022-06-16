package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.model.Post;

import java.util.List;

public interface PostService {
    void addPost(Post post);
    List<PostDto> getAllPosts();
}
