package com.strbanik.PostManager.repository;

import com.strbanik.PostManager.model.Post;
import com.strbanik.PostManager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAll();
}
