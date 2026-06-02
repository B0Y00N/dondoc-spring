package com.example.dondocStudy.dto;

import lombok.Data;

@Data
public class CategoryDto {
    // PK
    private Long id;

    private String name;
    private String icon;
    private String type;
}