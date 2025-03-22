package com.nefity.Nefity.Likes.service.impl;

import com.nefity.Nefity.Likes.model.Likes;
import com.nefity.Nefity.Likes.repository.LikesRepository;
import com.nefity.Nefity.Likes.service.LikesService;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.repository.PostsRepository;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikesServiceImpl implements LikesService {
    private final LikesRepository repository;
    private final PostsRepository postsRepository;
    private final UserInfoRepository userInfoRepository;

    @Override
    public List<Likes> getAllLikesForPost(Long postId) {
        return repository.findByPostId(postId);
    }


    @Override
    public Likes addLike(Likes like, Long postId) {
        System.out.println("Adding like for postId: " + postId);
        System.out.println("User ID: " + (like.getUser() != null ? like.getUser().getId() : "NULL"));

        Posts post = postsRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));

        UserInfo user = userInfoRepository.findById(like.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        like.setPost(post);
        like.setUser(user);

        return repository.save(like);
    }

    @Override
    public void removeLike(Long id) {
        repository.deleteById(id);
    }
}