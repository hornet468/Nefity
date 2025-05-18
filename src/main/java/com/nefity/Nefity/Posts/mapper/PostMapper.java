package com.nefity.Nefity.Posts.mapper;

import com.nefity.Nefity.Likes.mapper.LikeMapper;
import com.nefity.Nefity.Posts.dto.PostDTO;
import com.nefity.Nefity.Posts.model.Posts;
import com.nefity.Nefity.Likes.dto.LikeDTO;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import com.nefity.Nefity.UserInfo.mapper.UserInfoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LikeMapper.class, UserInfoMapper.class})
public interface PostMapper {
    PostDTO toDTO(Posts post);

    List<PostDTO> toDTOList(List<Posts> posts);
}