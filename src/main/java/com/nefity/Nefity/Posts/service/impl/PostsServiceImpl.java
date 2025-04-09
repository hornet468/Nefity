package com.nefity.Nefity.Posts.service.impl;

import com.nefity.Nefity.Likes.dto.LikeDTO;
import com.nefity.Nefity.Posts.dto.PostDTO;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.repository.PostsRepository;
import com.nefity.Nefity.Posts.service.PostsService;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class PostsServiceImpl implements PostsService {
    private final  PostsRepository repository;
    private final UserInfoRepository userInfoRepository;

    @Override
    public List<PostDTO> getAllPosts() {
        return  repository.findAll().stream()
                .map(post -> new PostDTO(
                        post.getId(),
                        post.getTitle(),
                        post.getText(),
                        post.getTimestamp(),
                        new UserInfoDTO(
                                post.getUser().getId(),
                                post.getUser().getNickName(),
                                post.getUser().getProfilePhoto()
                        ),
                        post.getLikes().stream()
                                .map(like -> new LikeDTO(
                                        like.getUser().getId(),
                                        new UserInfoDTO(
                                                like.getUser().getId(),
                                                like.getUser().getNickName(),
                                                like.getUser().getProfilePhoto()
                                        )
                                )).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
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
