package com.nefity.Nefity.Likes.dto;

import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LikeDTO {
    private long id;
    private UserInfoDTO user;
}
