package com.nefity.Nefity.Posts.dto;

import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String text;
    private LocalDateTime timestamp;
    private UserInfoDTO user;
}
