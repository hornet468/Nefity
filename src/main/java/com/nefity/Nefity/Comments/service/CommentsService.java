package com.nefity.Nefity.Comments.service;

import com.nefity.Nefity.Comments.model.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentsService {
    List<Comments> getAllComments();
    Comments addComment(Long postId,Comments comment);
    void deleteComment(long id);
    Comments updateComments(Comments comment);
}
