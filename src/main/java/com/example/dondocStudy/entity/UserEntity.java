package com.example.dondocStudy.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String userId;
    private String userPassword;
    private String name;
    private Integer age;
    private Integer currentPigLevel;
    private Integer currentHouseLevel;
    private Long monthlyIncome;
    private Integer targetExpenseRatio;
    private String createdAt;
}