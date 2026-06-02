package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecordDto {
    // PK
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