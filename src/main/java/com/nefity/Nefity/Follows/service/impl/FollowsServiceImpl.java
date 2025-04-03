package com.nefity.Nefity.Follows.service.impl;

import com.nefity.Nefity.Follows.model.Follows;
import com.nefity.Nefity.Follows.repository.FollowsRepository;
import com.nefity.Nefity.Follows.service.FollowsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Позначає що це сервісний клас
@AllArgsConstructor // Автоматично створює конструктори і ініціалізує

public class FollowsServiceImpl implements FollowsService {
    private final FollowsRepository reposetory;

    @Override
    public List<Follows> getAllUserFollows() {
        return reposetory.findAll();
    }

    @Override
    public Follows getUserFollowById(Follows follow) {
        Follows follows = reposetory.findById(follow.getId())
                .orElseThrow(() -> new RuntimeException("follow not found"));
        return follows;
    }


}
