package com.nefity.Nefity.Auth.service;

import com.nefity.Nefity.Auth.dto.JwtAuthenticationDto;
import com.nefity.Nefity.Auth.dto.RefreshTokenDto;
import com.nefity.Nefity.Auth.dto.UserCredentialDto;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    JwtAuthenticationDto singIn(UserCredentialDto userCredentialDto);
    JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto);
    UserInfo addUserInfo(UserInfo User);
}
