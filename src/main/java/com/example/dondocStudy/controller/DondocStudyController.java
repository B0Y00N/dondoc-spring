package com.example.dondocStudy.controller;

import com.example.dondocStudy.dto.DataDto;
import com.example.dondocStudy.repository.DataRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Tag(name = "Dondoc API", description = "가계부 및 농장 데이터 조회 API")
@RestController
@RequestMapping("/api") // 공통 경로 설정
public class DondocStudyController {

    private final DataRepository dataRepository;

    public DondocStudyController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Operation(summary = "전체 사용자 조회")
    @GetMapping("/users")
    public List<DataDto.UserDto> getAllUsers() throws IOException {
        return dataRepository.loadAllData().getUsers();
    }

    @Operation(summary = "전체 농장 조회")
    @GetMapping("/farms")
    public List<DataDto.FarmDto> getAllFarms() throws IOException {
        return dataRepository.loadAllData().getFarms();
    }

    @Operation(summary = "농장 멤버 매핑 정보 조회")
    @GetMapping("/farm-members")
    public List<DataDto.FarmMemberDto> getAllFarmMembers() throws IOException {
        return dataRepository.loadAllData().getFarm_members();
    }

    @Operation(summary = "카테고리 목록 조회")
    @GetMapping("/categories")
    public List<DataDto.CategoryDto> getAllCategories() throws IOException {
        return dataRepository.loadAllData().getCategories();
    }

    @Operation(summary = "가계부 내역 조회")
    @GetMapping("/records")
    public List<DataDto.RecordDto> getAllRecords() throws IOException {
        return dataRepository.loadAllData().getRecords();
    }

    @Operation(summary = "월간 히스토리 조회")
    @GetMapping("/monthly-histories")
    public List<DataDto.MonthlyHistoryDto> getAllMonthlyHistories() throws IOException {
        return dataRepository.loadAllData().getMonthly_history();
    }
}