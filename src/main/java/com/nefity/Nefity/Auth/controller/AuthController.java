package com.nefity.Nefity.Auth.controller;

import com.nefity.Nefity.Auth.dto.JwtAuthenticationDto;
import com.nefity.Nefity.Auth.dto.RefreshTokenDto;
import com.nefity.Nefity.Auth.dto.UserCredentialDto;
import com.nefity.Nefity.Auth.service.AuthService;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
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
    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthenticationDto> signIN(@RequestBody UserCredentialDto userCredentialDto) {
        try {
            JwtAuthenticationDto jwtAuthenticationDto = service.singIn(userCredentialDto);
            return ResponseEntity.ok(jwtAuthenticationDto);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }

    @PostMapping("/refresh")
    public JwtAuthenticationDto refresh(@RequestBody RefreshTokenDto refreshTokenDto) {
        return service.refreshToken(refreshTokenDto);
    }
}
