package com.nefity.Nefity.Likes.dto;

import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDTO {
    private long id;
    private UserInfoDTO user;
}
