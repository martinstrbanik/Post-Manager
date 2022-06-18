package com.strbanik.PostManager.dto.mapper;


import com.strbanik.PostManager.dto.model.PostDto;
import com.strbanik.PostManager.model.Post;

public class PostMapper {

   public static PostDto toPostDto(Post post){
       return new PostDto()
               .setId(post.getId())
               .setUserId(post.getUserId())
               .setBody(post.getBody())
               .setTitle(post.getTitle());
   }

    public static Post toPost(PostDto postDto){
        return new Post()
                .setId(postDto.getId())
                .setUserId(postDto.getUserId())
                .setBody(postDto.getBody())
                .setTitle(postDto.getTitle());
    }

}
