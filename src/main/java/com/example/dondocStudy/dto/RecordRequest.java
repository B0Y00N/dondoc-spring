package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecordRequest {
    @JsonProperty("user_id")
    private String userId;
}