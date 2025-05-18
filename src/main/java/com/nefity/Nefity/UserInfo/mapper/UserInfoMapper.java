package com.nefity.Nefity.UserInfo.mapper;

import com.nefity.Nefity.UserInfo.Model.UserInfo;
import com.nefity.Nefity.UserInfo.dto.UserInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfoDTO toDTO(UserInfo userInfo);

    List<UserInfoDTO> toDTOList(List<UserInfo> userInfoList);
}
