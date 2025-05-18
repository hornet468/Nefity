package com.nefity.Nefity.Posts.dto;

import com.nefity.Nefity.Likes.dto.LikeDTO;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String text;
    private LocalDateTime timestamp;
    private UserInfoDTO user;
    private List<LikeDTO> likes;
}
