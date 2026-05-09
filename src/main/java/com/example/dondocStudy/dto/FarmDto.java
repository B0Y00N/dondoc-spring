package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FarmDto {

    @Data
    public static class Info {
        private Long id;
        private String name;
        @JsonProperty("created_at")
        private String createdAt;
    }

    @Data
    public static class FarmMember {
        private Long id;
        @JsonProperty("user_id")
        private Long userId;
        @JsonProperty("farm_id")
        private Long farmId;
        @JsonProperty("joined_at")
        private String joinedAt;
    }
}

