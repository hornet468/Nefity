package com.nefity.Nefity.Posts.service.impl;

import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.service.PostsService;

import java.util.List;

public class PostsServiceImpl implements PostsService {
    @Override
    public List<Posts> getAllPosts() {
        return List.of();
    }

    @Override
    public Posts addPost(Posts Post) {
        return null;
    }

    @Override
    public void deletePost(String title) {

    }

    @Override
    public Posts updatePosts(Posts Post) {
        return null;
    }
}
