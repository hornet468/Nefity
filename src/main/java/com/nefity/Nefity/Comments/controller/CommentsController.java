package com.nefity.Nefity.Comments.controller;


import com.nefity.Nefity.Comments.model.Comments;
import com.nefity.Nefity.Comments.service.CommentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentsController {
    private final CommentsService service;
    @GetMapping
    public List<Comments> getAllComments() {
        return service.getAllComments();
    }
    @PostMapping("add_comment/{post_id}")
    public Comments addComment(@PathVariable Long post_id,  @RequestBody Comments comment) {
        return service.addComment(post_id, comment);
    }
    @PutMapping("update_comment")
    public Comments updateComment(@RequestBody Comments comment) {
        return service.updateComments(comment);
    }
    @DeleteMapping("delete_comment/{id}")
    public void deleteComments(@PathVariable long id ) {
        service.deleteComment(id);
    }
}
