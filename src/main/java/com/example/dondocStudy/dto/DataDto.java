package com.example.dondocStudy.dto;

import lombok.Data;
import java.util.List;

@Data
public class DataDto {
    private List<UserDto> users;
    private List<FarmDto> farms;
    private List<FarmMemberDto> farm_members;
    private List<CategoryDto> categories;
    private List<RecordDto> records;
    private List<MonthlyHistoryDto> monthly_history;

    @Data
    public static class UserDto {
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
    public static class FarmDto {
        private Long id;
        private String name;
        private String created_at;
    }

    @Data
    public static class FarmMemberDto {
        private Long id;
        private Long user_id;
        private Long farm_id;
        private String joined_at;
    }

    @Data
    public static class CategoryDto {
        private Long id;
        private String name;
        private String icon;
        private String type;
    }

    @Data
    public static class RecordDto {
        private Long id;
        private Long user_id;
        private Long category_id;
        private Long amount;
        private String description;
        private String memo;
        private String record_date;
        private String created_at;
    }

    @Data
    public static class MonthlyHistoryDto {
        private Long id;
        private Long user_id;
        private String target_month;
        private Double avg_ratio;
        private Integer house_level;
    }
}