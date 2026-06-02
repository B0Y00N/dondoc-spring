package com.example.dondocStudy.controller;

import com.example.dondocStudy.dto.CategoryDto;
import com.example.dondocStudy.dto.RecordDto;
import com.example.dondocStudy.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Record API", description = "거래 내역 데이터 조회 API")
@RestController
@RequestMapping("/api/records") // 공통 경로 설정
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @Operation(summary = "카테고리 목록 조회")
    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories() {
        return recordService.findAllCategories();
    }

    @Operation(summary = "가계부 내역 조회")
    @GetMapping("")
    public List<RecordDto> getAllRecords() {
        return recordService.findAllRecords();
    }
}