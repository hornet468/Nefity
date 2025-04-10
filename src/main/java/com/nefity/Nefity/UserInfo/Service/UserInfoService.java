package com.nefity.Nefity.UserInfo.Service;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserInfoService {

    Optional<UserInfo> getUserInfo(long id);
    List<UserInfo> getAllUserInfo();
    UserInfo addUserInfo(UserInfo User);
    UserInfo updateUserInfo(UserInfo User);
    void deleteUserId(long id);
}
