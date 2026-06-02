package com.example.dondocStudy.service;

import com.example.dondocStudy.dto.CategoryDto;
import com.example.dondocStudy.dto.RecordDto;

import java.util.List;

public interface RecordService {
    // 전체 내역 조회
    // 근데 특정 사용자의 전체 내역으로 가는게 맞지 않음??
    List<RecordDto> findAllRecords();

    // 전체 카테고리 목록 조회
    List<CategoryDto> findAllCategories();
}
