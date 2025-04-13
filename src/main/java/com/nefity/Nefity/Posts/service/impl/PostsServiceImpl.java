package com.nefity.Nefity.Posts.service.impl;

import com.nefity.Nefity.Likes.dto.LikeDTO;
import com.nefity.Nefity.Likes.mapper.LikeMapper;
import com.nefity.Nefity.Posts.dto.PostDTO;
import com.nefity.Nefity.Posts.mapper.PostMapper;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.repository.PostsRepository;
import com.nefity.Nefity.Posts.service.PostsService;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import com.nefity.Nefity.UserInfo.mapper.UserInfoMapper;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class PostsServiceImpl implements PostsService {
    private final PostsRepository repository;
    private final UserInfoRepository userInfoRepository;
    private final PostMapper postMapper;
    private final LikeMapper likeMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return repository.findAll().stream()
                .map(post -> postMapper.toDTO(post))
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
    public Posts updatePosts(Posts post) {
        return repository.save(post);
    }
}