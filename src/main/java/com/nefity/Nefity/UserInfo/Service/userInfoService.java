package com.nefity.Nefity.UserInfo.Service;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface userInfoService {

    UserInfo getUserInfo(UserInfo User);
    UserInfo addUserInfo(UserInfo User);
    void deleteUser(String nickName);
}
