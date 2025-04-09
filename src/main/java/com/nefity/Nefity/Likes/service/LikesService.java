package com.nefity.Nefity.Likes.service;

import com.nefity.Nefity.Likes.dto.LikeDTO;
import com.nefity.Nefity.Likes.model.Likes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikesService {
    List<LikeDTO> getAllLikesForPost(Long postId);
    Likes addLike(Likes like, Long postId);
    void removeLike(Long id);
}
