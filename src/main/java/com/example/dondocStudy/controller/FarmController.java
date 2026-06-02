package com.example.dondocStudy.controller;

import com.example.dondocStudy.dto.FarmDto;
import com.example.dondocStudy.dto.FarmMemberDto;
import com.example.dondocStudy.service.FarmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Farm API", description = "농장 데이터 조회 API")
@RestController
@RequestMapping("/api/farms") // 공통 경로 설정
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;

    @Operation(summary = "전체 농장 조회")
    @GetMapping("")
    public List<FarmDto> getAllFarms() {
        return farmService.findAllFarms();
    }

    @Operation(summary = "농장 멤버 매핑 정보 조회")
    @GetMapping("/members")
    public List<FarmMemberDto> getAllFarmMembers() {
        return farmService.findAllFarmMembers();
    }
}