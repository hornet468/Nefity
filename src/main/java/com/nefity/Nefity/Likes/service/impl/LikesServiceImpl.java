package com.nefity.Nefity.Likes.service.impl;

import com.nefity.Nefity.Likes.dto.LikeDTO;
import com.nefity.Nefity.Likes.model.Likes;
import com.nefity.Nefity.Likes.repository.LikesRepository;
import com.nefity.Nefity.Likes.service.LikesService;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.repository.PostsRepository;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LikesServiceImpl implements LikesService {
    private final LikesRepository repository;
    private final PostsRepository postsRepository;
    private final UserInfoRepository userInfoRepository;

    @Override
    public List<LikeDTO> getAllLikesForPost(Long postId) {


        return repository.findByPostId(postId).stream()
                .map(likes -> new LikeDTO(
                        likes.getId(),
                        new UserInfoDTO(
                                likes.getUser().getId(),
                                likes.getUser().getNickName(),
                                likes.getUser().getProfilePhoto()
                                )

                ))
                .collect(Collectors.toList());
    }

    @Override
    public Likes addLike(Likes like, Long postId) {
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