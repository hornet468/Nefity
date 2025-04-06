package com.nefity.Nefity.UserInfo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDTO {
    @Id
    @GeneratedValue
    private Long id;
    private String profilePhoto;
    private String nickName;
}
