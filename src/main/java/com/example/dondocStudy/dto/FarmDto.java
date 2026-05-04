package com.example.dondocStudy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FarmDto {
    private List<FarmDto.info> farms;
    private List<FarmDto.FarmMember> farm_members;

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

