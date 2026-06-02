package com.example.dondocStudy.entity;

import lombok.Data;

@Data
public class FarmMemberEntity {
    private Long id;
    private Long userId;
    private Long farmId;
    private String joinedAt;
}

