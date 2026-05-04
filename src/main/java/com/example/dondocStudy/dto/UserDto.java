package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private List<UserDto.Info> users;
    private List<UserDto.MonthlyHistory> monthly_history;

    @Data
    public static class Info {
        private Long id;
        private String user_id;
        private String user_password;
        private String name;
        private Integer age;
        private Integer current_pig_level;
        private Integer current_house_level;
        private Long monthly_income;
        private Integer target_expense_ratio;
        private String created_at;
    }

    @Data
    public static class MonthlyHistory {
        private Long id;
        private Long user_id;
        private String target_month;
        private Double avg_ratio;
        private Integer house_level;
    }
}