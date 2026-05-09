package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    @Data
    public static class Info {
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

    @Data
    public static class MonthlyHistory {
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
}