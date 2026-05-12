package com.example.dondocStudy.mapper;

import com.example.dondocStudy.dto.FarmDto;
import com.example.dondocStudy.entity.FarmEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmMapper {
    FarmEntity toEntity(FarmDto dto);
    FarmDto toDto(FarmEntity entity);
}
