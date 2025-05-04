package com.nefity.Nefity.Auth.controller;

import com.nefity.Nefity.Auth.service.AuthService;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService service;
    @PostMapping("/register")
    public UserInfo addUserInfo(@RequestBody UserInfo User) {

        return service.addUserInfo(User);
    }
}
