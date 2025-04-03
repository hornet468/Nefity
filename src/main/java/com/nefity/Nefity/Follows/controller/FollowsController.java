package com.nefity.Nefity.Follows.controller;

import com.nefity.Nefity.Follows.model.Follows;
import com.nefity.Nefity.Follows.service.FollowsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/follows")

    public class FollowsController {
        private final FollowsService service;                // ТУТ НАПИСАВ

    @GetMapping
    public List<Follows> getAllUserFollows() {
        return service.getAllUserFollows();               // ТУТ НАПИСАВ
    }


}
