package com.nefity.Nefity.Follows.service.impl;

import com.nefity.Nefity.Follows.model.Follows;
import com.nefity.Nefity.Follows.repository.FollowsRepository;
import com.nefity.Nefity.Follows.service.FollowsService;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Позначає що це сервісний клас
@AllArgsConstructor // Автоматично створює конструктори і ініціалізує

public class FollowsServiceImpl implements FollowsService {
    private final FollowsRepository followsRepository;
    private final UserInfoRepository userInfoRepository;


    @Override
    public List<Follows> getAllUserFollows() {
        return followsRepository.findAll();
    }

    @Override
    public Optional<Follows> getUserFollowById(long id) {
        return followsRepository.findById(id);
    }

    @Override
    public  Follows addFollows(Follows follows, Long userId) {

        UserInfo user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        follows.setUser(user);
        return followsRepository.save(follows);
    }

    @Override
    public void deleteFollows(Long id) {
        followsRepository.deleteById(id);
    }


}
