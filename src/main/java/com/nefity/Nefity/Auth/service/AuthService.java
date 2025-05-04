package com.nefity.Nefity.Auth.service;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    UserInfo addUserInfo(UserInfo User);
}
