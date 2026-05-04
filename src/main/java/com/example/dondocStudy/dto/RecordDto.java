package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordDto {
    private List<RecordDto.CategoryInfo> categories;
    private List<RecordDto.Info> records;

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
        private Long user_id;
        private Long category_id;
        private Long amount;
        private String description;
        private String memo;
        private String record_date;
        private String created_at;
    }
}