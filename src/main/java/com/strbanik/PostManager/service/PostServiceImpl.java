package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.mapper.PostMapper;
import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.dto.model.UserDto;
import com.strbanik.PostManager.exception.GenericException;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public void addPost(Post post) {
        if (userService.getUserFromExternalApi(post.getUserId())!=null)
        postRepository.save(post);
        else
            System.out.println("hahaaa");


    }

    @Override
    public PostDto getPostById(int postId) throws GenericException {

        if (postRepository.findAll().stream()
        .anyMatch(post -> post.getId()==postId)){
            return PostMapper.toPostDto(postRepository.findById(postId).get());
        }
        else if(getPostsFromExternalApi().stream()
        .anyMatch(postDto -> postDto.getId()==postId)){
            List<PostDto> postDtos = getPostsFromExternalApi().stream()
                    .filter(postDto -> postDto.getId() == postId)
                    .collect(Collectors.toList());
            postRepository.save(PostMapper.toPost(postDtos.get(0)));
            return postDtos.get(0);
        }
        else {
            throw new GenericException("Post not found");
        }
    }

    @Override
    public List<PostDto> getPostsByUserId(int userId) {
        return this.postRepository.findAllByUserId(userId).stream()
                .map(PostMapper::toPostDto)
                .collect(Collectors.toList());
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
    public List<PostDto> getPostsFromExternalApi() {
        RestTemplate restTemplate =new RestTemplate();
        PostDto[] postDtos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", PostDto[].class);
        return Arrays.stream(postDtos).toList();

    }
}
