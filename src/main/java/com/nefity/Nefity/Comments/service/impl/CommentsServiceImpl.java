package com.nefity.Nefity.Comments.service.impl;

import com.nefity.Nefity.Comments.model.Comments;
import com.nefity.Nefity.Comments.repository.CommentsRepository;
import com.nefity.Nefity.Comments.service.CommentsService;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentsServiceImpl implements CommentsService {
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    @Override
    public List<Comments> getAllComments() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments addComment(Long postId, Comments comment) {
        Posts post = postsRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Пост не знайдено"));

        comment.setPost(post); // Встановлюємо зв’язок коментаря з постом
        return commentsRepository.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        commentsRepository.deleteById(id);
    }

    @Override
    public Comments updateComments(Comments comment) {
        Comments existingComment = commentsRepository.findById(comment.getId())
                .orElseThrow(() -> new RuntimeException("Коментар не знайдено"));

        existingComment.setCommentsText(comment.getCommentsText()); // Оновлення тексту
        return commentsRepository.save(existingComment);
    }
}
