package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecordDto {
    @Data
    public static class CategoryInfo {
        private Long id;
        private String name;
        private String icon;
        private String type;
    }

    @Data
    public static class Info {
        private Long id;
        @JsonProperty("user_id")
        private Long userId;
        @JsonProperty("category_id")
        private Long categoryId;
        private Long amount;
        private String description;
        private String memo;
        @JsonProperty("record_date")
        private String recordDate;
        @JsonProperty("created_at")
        private String createdAt;
    }
}