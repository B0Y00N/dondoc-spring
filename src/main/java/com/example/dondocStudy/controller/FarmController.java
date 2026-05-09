package com.example.dondocStudy.controller;

import com.example.dondocStudy.entity.FarmEntity;
import com.example.dondocStudy.entity.FarmMemberEntity;
import com.example.dondocStudy.repository.FarmMemberRepository;
import com.example.dondocStudy.repository.FarmRepository;
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
    private final FarmRepository farmRepository;
    private final FarmMemberRepository farmMemberRepository;

    @Operation(summary = "전체 농장 조회")
    @GetMapping("")
    public List<FarmEntity> getAllFarms() {
        return farmRepository.findAll();
    }

    @Operation(summary = "농장 멤버 매핑 정보 조회")
    @GetMapping("/members")
    public List<FarmMemberEntity> getAllFarmMembers() {
        return farmMemberRepository.findAll();
    }
}