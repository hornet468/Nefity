package com.nefity.Nefity.Posts.service.impl;

import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.repository.PostsRepository;
import com.nefity.Nefity.Posts.service.PostsService;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class PostsServiceImpl implements PostsService {
    private final  PostsRepository repository;
    private final UserInfoRepository userInfoRepository;

    @Override
    public List<Posts> getAllPosts() {
        return repository.findAll();
    }

    @Override
    public Posts addPost(Posts post) {
        UserInfo user = userInfoRepository.findById(post.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        post.setUser(user);
        return repository.save(post);
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
