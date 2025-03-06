package com.nefity.Nefity.Posts.service;

import com.nefity.Nefity.Posts.model.Posts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostsService {

    List<Posts> getAllPosts();
    Posts addPost(Posts Post);
    void deletePost(String title);
    Posts updatePosts(Posts Post);
}
