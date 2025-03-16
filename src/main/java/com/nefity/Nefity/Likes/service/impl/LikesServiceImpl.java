package com.nefity.Nefity.Likes.service.impl;

import com.nefity.Nefity.Likes.model.Likes;
import com.nefity.Nefity.Likes.repository.LikesRepository;
import com.nefity.Nefity.Likes.service.LikesService;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikesServiceImpl implements LikesService {
    private final LikesRepository repository;
    private final PostsRepository postsRepository; // Додаємо репозиторій для постів

    @Override
    public List<Likes> getAllLikesForPost(Long postId) {
        return repository.findByPostId(postId);
    }

    @Override
    public Likes addLike(Likes like, Long postId) { // Додаємо параметр postId
        Posts post = postsRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));

        like.setPost(post); // Прив'язуємо лайк до поста
        return repository.save(like);
    }

    @Override
    public void removeLike(Long id) {
        repository.deleteById(id);
    }
}