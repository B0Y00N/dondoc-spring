package com.example.dondocStudy.mapper;

import com.example.dondocStudy.dto.FarmMemberDto;
import com.example.dondocStudy.entity.FarmMemberEntity;
import org.mapstruct.Mapper;

@Mapper
public interface FarmMemberMapper {
    FarmMemberEntity toEntity(FarmMemberDto dto);
    FarmMemberDto toDto(FarmMemberEntity entity);
}
