package com.nefity.Nefity.Posts.service.impl;

import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.repository.PostsRepository;
import com.nefity.Nefity.Posts.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class PostsServiceImpl implements PostsService {
    private final  PostsRepository repository;

    @Override
    public List<Posts> getAllPosts() {
        return repository.findAll();
    }

    @Override
    public Posts addPost(Posts Post) {
        return repository.save(Post);
    }

    @Override
    public void deletePost(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Posts updatePosts(Posts Post) {
        return  repository.save(Post);
    }
}
