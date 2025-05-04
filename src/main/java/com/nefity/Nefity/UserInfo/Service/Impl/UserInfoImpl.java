package com.nefity.Nefity.UserInfo.Service.Impl;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import com.nefity.Nefity.UserInfo.Service.UserInfoService;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import com.nefity.Nefity.UserInfo.mapper.UserInfoMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Primary
public class UserInfoImpl implements UserInfoService {
    private final UserInfoRepository repository;
    private PasswordEncoder passwordEncoder;
    private UserInfoMapper mapper;

    @Override
    public Optional<UserInfo> getUserInfo(long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserInfoDTO> getAllUserInfo() {
        List<UserInfo> userInfoList = repository.findAll();
        System.out.println("Fetched users: " + userInfoList.size()); // Додайте лог
        return mapper.toDTOList(userInfoList);
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