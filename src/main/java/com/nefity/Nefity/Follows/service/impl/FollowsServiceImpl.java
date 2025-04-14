package com.nefity.Nefity.Follows.service.impl;

import com.nefity.Nefity.Follows.dto.FollowsDTO;
import com.nefity.Nefity.Follows.model.Follows;
import com.nefity.Nefity.Follows.repository.FollowsRepository;
import com.nefity.Nefity.Follows.service.FollowsService;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // Позначає що це сервісний клас
@AllArgsConstructor // Автоматично створює конструктори і ініціалізує

public class FollowsServiceImpl implements FollowsService {
    private final FollowsRepository followsRepository;
    private final UserInfoRepository userInfoRepository;


    @Override
    public List<FollowsDTO> getAllUserFollows() {
        List<Follows> userFollowsList = followsRepository.findAll();
        return userFollowsList.stream()
                .map(follows -> new FollowsDTO(follows.getId(),
                        new UserInfoDTO(follows.getUser().getId(),
                                follows.getUser().getProfilePhoto() ,
                                follows.getUser().getNickName())))
                .collect(Collectors.toList());
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
