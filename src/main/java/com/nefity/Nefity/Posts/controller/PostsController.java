package com.nefity.Nefity.Posts.controller;

import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Posts.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostsController {

    private final PostsService service;

    @GetMapping
    public List<Posts> getAllPosts() {
        return service.getAllPosts();
    }
    @PostMapping("add_post")
    public Posts addPost(@RequestBody Posts Post) {
        return service.addPost(Post);
    }

    @DeleteMapping("delete_post/{id}")
    public void deletePost(@PathVariable Long id) {
        service.deletePost(id);
    }

    @PutMapping("update_post")
    public Posts updatePost(@RequestBody Posts Post) {
        return service.updatePosts(Post);
    }

}
