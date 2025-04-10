package com.nefity.Nefity.Follows.controller;

import com.nefity.Nefity.Follows.model.Follows;
import com.nefity.Nefity.Follows.service.FollowsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/follows")

    public class FollowsController {
        private final FollowsService service;

    @GetMapping
    public List<Follows> getAllUserFollows() {
        return service.getAllUserFollows();
    }

    @GetMapping("/{id}")
    public Optional <Follows> getUserFollowById(@PathVariable long id) {
        return service.getUserFollowById(id);
    }

    @PostMapping("add_follows/{userId}")
    public Follows addFollows(@RequestBody Follows follows, @PathVariable  Long userId) {
        return service.addFollows(follows , userId);
    }

    @DeleteMapping("delete_user/{userId}")
    public void deleteFollows(@PathVariable Long userId) {
        service.deleteFollows(userId);
    }




}
