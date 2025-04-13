package com.nefity.Nefity.Likes.mapper;

import com.nefity.Nefity.Likes.dto.LikeDTO;
import com.nefity.Nefity.Likes.model.Likes;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import com.nefity.Nefity.UserInfo.mapper.UserInfoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserInfoMapper.class)
public interface LikeMapper {
    @Mapping(target = "user", source = "like.user")
    LikeDTO toDTO(Likes like);

    List<LikeDTO> toDTOList(List<Likes> likes);
}