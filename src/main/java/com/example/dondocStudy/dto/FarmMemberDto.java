package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FarmMemberDto {
    // PK
    private Long id;

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("farm_id")
    private Long farmId;
    @JsonProperty("joined_at")
    private String joinedAt;
}

