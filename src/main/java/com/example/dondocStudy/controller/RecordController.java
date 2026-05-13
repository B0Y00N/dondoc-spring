package com.example.dondocStudy.controller;

import com.example.dondocStudy.dto.CategoryDto;
import com.example.dondocStudy.dto.RecordDto;
import com.example.dondocStudy.dto.RecordRequest;
import com.example.dondocStudy.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Record API", description = "거래 내역 데이터 조회 API")
@RestController
@RequestMapping("/api/records") // 공통 경로 설정
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @Operation(summary = "카테고리 목록 조회")
    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories() {
        return recordService.findAllCategories();
    }

    @Operation(summary = "가계부 내역 조회")
    @GetMapping("/all")
    public List<RecordDto> getAllRecords() {
        return recordService.findAllRecords();
    }

    @Operation(summary = "특정 사용자 가계부 내역 조회")
    @PostMapping("")
    public List<RecordDto> getRecords(@RequestBody RecordRequest recordRequest) {
        return recordService.findRecords(recordRequest);
    }
}