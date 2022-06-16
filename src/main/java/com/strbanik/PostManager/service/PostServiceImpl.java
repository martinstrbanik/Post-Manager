package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.mapper.PostMapper;
import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

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
