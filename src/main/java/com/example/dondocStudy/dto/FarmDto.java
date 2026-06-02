package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FarmDto {
    // PK
    private Long id;

    private String name;

    @JsonProperty("created_at")
    private String createdAt;
}

