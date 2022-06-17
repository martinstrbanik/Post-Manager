package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.mapper.PostMapper;
import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return this.postRepository.findAll().stream()
                .map(PostMapper::toPostDto)
                .collect(Collectors.toList());
    }
}
