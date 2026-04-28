package com.example.dondocStudy.dto;

import lombok.Data;

@Data
public class FarmDto {
    @Data
    public static class info {
        private Long id;
        private String name;
        private String created_at;
    }

    @Data
    public static class FarmMember {
        private Long id;
        private Long user_id;
        private Long farm_id;
        private String joined_at;
    }
}

