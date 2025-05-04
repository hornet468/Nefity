package com.nefity.Nefity.Auth.service.impl;

import com.nefity.Nefity.Auth.service.AuthService;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserInfoRepository repository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo addUserInfo(UserInfo User) {
        User.setPassword(passwordEncoder.encode(User.getPassword()));
        return repository.save(User);
    }
}
