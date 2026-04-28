package com.example.dondocStudy.controller;

import com.example.dondocStudy.dto.FarmDto;
import com.example.dondocStudy.repository.DataRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Tag(name = "Farm API", description = "농장 데이터 조회 API")
@RestController
@RequestMapping("/api/farms") // 공통 경로 설정
public class FarmController {

    private final DataRepository dataRepository;

    public FarmController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Operation(summary = "전체 농장 조회")
    @GetMapping("")
    public List<FarmDto.info> getAllFarms() throws IOException {
        return dataRepository.loadAllData().getFarms();
    }

    @Operation(summary = "농장 멤버 매핑 정보 조회")
    @GetMapping("/members")
    public List<FarmDto.FarmMember> getAllFarmMembers() throws IOException {
        return dataRepository.loadAllData().getFarm_members();
    }
}