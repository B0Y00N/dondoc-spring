package com.example.dondocStudy.entity;

import lombok.Data;

@Data
public class MonthlyHistoryEntity {
    private Long id;
    private Long userId;
    private String targetMonth;
    private Double avgRatio;
    private Integer houseLevel;
}