package com.example.dondocStudy.mapper;

import com.example.dondocStudy.dto.MonthlyHistoryDto;
import com.example.dondocStudy.entity.MonthlyHistoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MonthlyHistoryMapper {

    MonthlyHistoryEntity toEntity(MonthlyHistoryDto dto);
    MonthlyHistoryDto toDto(MonthlyHistoryEntity entity);
}
