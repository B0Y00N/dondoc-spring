package com.example.dondocStudy.service;

import com.example.dondocStudy.dto.FarmDto;
import com.example.dondocStudy.dto.FarmMemberDto;

import java.util.List;

public interface FarmService {
    // 전체 농장 조회
    List<FarmDto> findAllFarms();

    // 전체 농장 멤버 조회
    // 특정 농장의 전체 멤버 조회로 가는게 맞지 않나??
    List<FarmMemberDto> findAllFarmMembers();
}
