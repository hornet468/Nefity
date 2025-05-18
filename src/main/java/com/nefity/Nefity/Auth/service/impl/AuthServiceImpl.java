package com.nefity.Nefity.Auth.service.impl;

import com.nefity.Nefity.Auth.JwtService;
import com.nefity.Nefity.Auth.dto.JwtAuthenticationDto;
import com.nefity.Nefity.Auth.dto.RefreshTokenDto;
import com.nefity.Nefity.Auth.dto.UserCredentialDto;
import com.nefity.Nefity.Auth.service.AuthService;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserInfoRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationDto singIn(UserCredentialDto userCredentialDto) {
        UserInfo userInfo = findByCredentials(userCredentialDto);
        return jwtService.generateAuthToken(userInfo.getNickName());
    }

    @Override
    public JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) {
        String refreshToken = refreshTokenDto.getRefreshToken();
        if (refreshToken != null && jwtService.validateJwtToken(refreshToken)) {
            String nickNameFromToken = jwtService.getNickNameFromToken(refreshToken);
            UserInfo userInfo = findByNickName(nickNameFromToken);
            // Генеруємо новий токен
            return jwtService.refreshBaseToken(userInfo.getNickName(), refreshToken);
        }
        throw new BadCredentialsException("Invalid refresh token");
    }

    @Override
    public UserInfo addUserInfo(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    private UserInfo findByCredentials(UserCredentialDto userCredentialDto) {
        Optional<UserInfo> optionalUserInfo = repository.findByNickName(userCredentialDto.getNickname());
        if (optionalUserInfo.isPresent()) {
            UserInfo userInfo = optionalUserInfo.get();
            if (passwordEncoder.matches(userCredentialDto.getPassword(), userInfo.getPassword())) {
                return userInfo;
            }
        }
        throw new BadCredentialsException("Invalid nickname or password");
    }

    private UserInfo findByNickName(String nickname) {
        return repository.findByNickName(nickname).orElseThrow(() -> new RuntimeException("User with nickname " + nickname + " not found"));
    }
}