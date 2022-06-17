package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.mapper.PostMapper;
import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public void addPost(Post post) {
//        if (userService.getUserFromExternalApi(post.getUserId())!=null)
        postRepository.save(post);


    }

    @Override
    public Post getPostById(int postId) {
        return this.postRepository.findById(postId).get();
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        return null;
    }

    @Override
    public void deletePost(int postId) {

    }

    @Override
    public void editPost(int postId) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        return this.postRepository.findAll().stream()
                .map(PostMapper::toPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object> getPostsFromExternalApi(int userId) {

//        List forObject = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", List.class);

        return null;
    }
}
