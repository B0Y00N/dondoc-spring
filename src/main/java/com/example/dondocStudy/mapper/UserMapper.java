package com.example.dondocStudy.mapper;

import com.example.dondocStudy.dto.UserDto;
import com.example.dondocStudy.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto dto);
    UserDto toDto(UserEntity entity);
}
