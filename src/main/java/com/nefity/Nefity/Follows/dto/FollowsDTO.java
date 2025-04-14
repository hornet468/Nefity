package com.nefity.Nefity.Follows.dto;

import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // Робить конструктор замість тебе, використовуючи твої поля
public class FollowsDTO {

    private Long id;
    private UserInfoDTO user;








}




