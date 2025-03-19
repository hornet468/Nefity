package com.nefity.Nefity.UserInfo.Service.Impl;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import com.nefity.Nefity.UserInfo.Service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Primary

public class UserInfoImpl implements UserInfoService {
    private final UserInfoRepository repository;

    @Override
    public Optional<UserInfo> getUserInfo(long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        return repository.findAll();
    }

    @Override
    public UserInfo addUserInfo(UserInfo User) {
        return repository.save(User);
    }

    @Override
    public UserInfo updateUserInfo(UserInfo User) {
        return repository.save(User);
    }

    @Override
    public void deleteUserId(long id) {
        repository.deleteById(id);
    }
}
