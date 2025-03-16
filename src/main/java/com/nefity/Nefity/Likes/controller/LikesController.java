package com.nefity.Nefity.Likes.controller;

import com.nefity.Nefity.Likes.model.Likes;
import com.nefity.Nefity.Likes.service.LikesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/likes")
public class LikesController {
    private final LikesService service;

    @GetMapping("/{postId}")
    public List<Likes> getAllLikesForPost(@PathVariable Long postId) {
        return service.getAllLikesForPost(postId);
    }
    @PostMapping("/{postId}")
    public Likes addLike(@RequestBody Likes like, @PathVariable Long postId) {
        return service.addLike(like, postId);
    }
    @DeleteMapping("remove_like/{id}")
    void removeLike(@PathVariable Long id) {
        service.removeLike(id);
    }
}
