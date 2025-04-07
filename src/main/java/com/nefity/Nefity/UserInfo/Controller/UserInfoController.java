package com.nefity.Nefity.UserInfo.Controller;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.Service.UserInfoService;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/userinfo")

public class UserInfoController {

    private final UserInfoService service;

    @GetMapping ("/get_by_id/{id}")
    public Optional<UserInfo> getUserInfo(@PathVariable long id) {
        return service.getUserInfo(id);
    }

    @GetMapping
    public List<UserInfoDTO> getAllUserInfo() {
        return service.getAllUserInfo();
    }

    @DeleteMapping("delete_user/{id}")
    public void deleteUserId(@PathVariable Long id) {

        service.deleteUserId(id);
    }

    @PutMapping("update_userinfo")
    public UserInfo updateUserInfo(@RequestBody UserInfo User) {

        return service.updateUserInfo(User);
    }

    @PostMapping("/add_userinfo")
    public UserInfo addUserInfo(@RequestBody UserInfo User) {

        return service.addUserInfo(User);
    }
}


