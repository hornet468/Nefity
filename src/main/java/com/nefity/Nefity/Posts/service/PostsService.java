package com.nefity.Nefity.Posts.service;

import com.nefity.Nefity.Posts.dto.PostDTO;
import com.nefity.Nefity.Posts.model.Posts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostsService {
    List<PostDTO> getAllPosts();
    Posts addPost(Posts post);
    void deletePost(Long id);
    Posts updatePosts(Posts Post);
}
