package com.strbanik.PostManager.service;

import com.strbanik.PostManager.dto.mapper.PostMapper;
import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.exception.GenericException;
import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public void addPost(PostDto postDto) throws GenericException{
        if (postRepository.findById(postDto.getId()).isPresent()){
            throw new GenericException("Post with the same id already exists");
        }
        else if (userService.getUsersFromExternalApi().stream()
        .anyMatch(userDto -> userDto.getId()==postDto.getUserId())){
            postRepository.save(PostMapper.toPost(postDto));
        }
        else {
            throw new GenericException("User with specified userId was not found");
        }


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
            throw new GenericException("Post with such id was not found");
        }
    }

    @Override
    public List<PostDto> getPostsByUserId(int userId) {
        return this.postRepository.findAllByUserId(userId).stream()
                .map(PostMapper::toPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePost(int postId) throws GenericException{
        if(!postRepository.findById(postId).equals(Optional.empty())) {
            postRepository.deleteById(postId);
        }
        else {
            throw new GenericException("Post with such id was not found");
        }
    }

    @Override
    public void editTitle(int postId, String title) throws GenericException {
        if (postRepository.findById(postId).isPresent()) {
            Post currentPost = postRepository.findById(postId).get();
            postRepository.save(currentPost.setTitle(title));
        }

        else {
            throw new GenericException("Post with such id was not found");
        }
    }

    @Override
    public void editBody(int postId, String body) throws GenericException {
        if (postRepository.findById(postId).isPresent()) {
            Post currentPost = postRepository.findById(postId).get();
            postRepository.save(currentPost.setBody(body));
        }

        else {
            throw new GenericException("Post with such id was not found");
        }
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
