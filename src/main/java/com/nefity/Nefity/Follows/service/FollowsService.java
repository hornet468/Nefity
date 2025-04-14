package com.nefity.Nefity.Follows.service;

import com.nefity.Nefity.Follows.dto.FollowsDTO;
import com.nefity.Nefity.Follows.model.Follows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FollowsService {

    List<FollowsDTO> getAllUserFollows();
    Optional <Follows> getUserFollowById(long id);
    Follows addFollows (Follows follows , Long userId)  ;
    void deleteFollows (Long id);

}
