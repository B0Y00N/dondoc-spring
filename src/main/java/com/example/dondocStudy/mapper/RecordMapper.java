package com.example.dondocStudy.mapper;

import com.example.dondocStudy.dto.RecordDto;
import com.example.dondocStudy.entity.RecordEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    RecordEntity toEntity(RecordDto dto);
    RecordDto toDto(RecordEntity entity);
}
