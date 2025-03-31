package com.nefity.Nefity.UserInfo.Repository;

import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByNickName(String nickname);

}
