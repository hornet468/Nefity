package com.nefity.Nefity.UserInfo.Service;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserInfoService {

    Optional<UserInfo> getUserInfo(long id);
    List<UserInfoDTO> getAllUserInfo();

    UserInfo addUserInfo(UserInfo User);
    UserInfo updateUserInfo(UserInfo User);

    void deleteUserId(long id);
}
