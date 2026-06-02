package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {
    // PK
    private Long id;

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_password")
    private String userPassword;

    private String name;
    private Integer age;

    @JsonProperty("current_pig_level")
    private Integer currentPigLevel;
    @JsonProperty("current_house_level")
    private Integer currentHouseLevel;
    @JsonProperty("monthly_income")
    private Long monthlyIncome;
    @JsonProperty("target_expense_ratio")
    private Integer targetExpenseRatio;
}