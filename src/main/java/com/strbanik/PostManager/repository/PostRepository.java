package com.strbanik.PostManager.repository;

import com.strbanik.PostManager.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
