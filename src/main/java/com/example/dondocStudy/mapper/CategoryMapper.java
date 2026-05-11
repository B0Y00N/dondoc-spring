package com.example.dondocStudy.mapper;

import com.example.dondocStudy.dto.CategoryDto;
import com.example.dondocStudy.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryEntity toEntity(CategoryDto dto);
    CategoryDto toDto(CategoryEntity entity);
}
