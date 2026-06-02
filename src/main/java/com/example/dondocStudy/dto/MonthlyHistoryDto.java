package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MonthlyHistoryDto {
    // PK
    private Long id;

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("target_month")
    private String targetMonth;
    @JsonProperty("avg_ratio")
    private Double avgRatio;
    @JsonProperty("house_level")
    private Integer houseLevel;
}