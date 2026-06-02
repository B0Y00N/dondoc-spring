package com.example.dondocStudy.entity;

import lombok.Data;

@Data
public class RecordEntity {
    private Long id;
    private Long userId;
    private Long categoryId;
    private Long amount;
    private String description;
    private String memo;
    private String recordDate;
    private String createdAt;
}