package com.nefity.Nefity.Follows.service;

import com.nefity.Nefity.Follows.model.Follows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FollowsService {

    List<Follows> getAllUserFollows();
    Follows getUserFollowById(Follows follow);
    Follows followInUser

}
