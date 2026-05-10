package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryDto {
    // PK
    private Long id;

    private String name;
    private String icon;
    private String type;
}