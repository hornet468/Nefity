package com.nefity.Nefity.UserInfo.Service.Impl;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Repository.UserInfoRepository;
import com.nefity.Nefity.config.MyUserInfoDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserInfoRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Пошук користувача за nickName: " + username);
        UserInfo user = repository.findByNickName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with nickName: " + username));
        System.out.println("Користувач знайдений: " + user.getNickName());
        return new MyUserInfoDetails(user);
    }
}
