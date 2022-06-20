package com.strbanik.PostManager.post;

import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    int userId = 2;

    List<Post> posts = new ArrayList<>(Arrays.asList(
            new Post(1,"title", "body", userId),
            new Post(2,"title", "body", userId),
            new Post(3,"title", "body", 3)
    ));

    @Test
    void itShouldFindAllPosts(){

        //given
        postRepository.saveAll(posts);

        //when
        List<Post> result = postRepository.findAll();

        //then
        assertThat(result).isEqualTo(posts);


    }

    @Test
    void itShouldFindAllByUserId(){
        //given
        postRepository.saveAll(posts);

        //when
        List<Post> result = postRepository.findAllByUserId(userId);

        //then
        assertThat(result).isEqualTo(Arrays.asList(
                new Post(1,"title", "body", userId),
                new Post(2,"title", "body", userId)
        ));
        
    }

}