package com.example.dondocStudy.service;

import com.example.dondocStudy.dto.CategoryDto;
import com.example.dondocStudy.dto.RecordDto;
import com.example.dondocStudy.mapper.CategoryMapper;
import com.example.dondocStudy.mapper.RecordMapper;
import com.example.dondocStudy.repository.CategoryRepository;
import com.example.dondocStudy.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService{
    private final RecordRepository recordRepository;
    private final CategoryRepository categoryRepository;
    private final RecordMapper recordMapper;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<RecordDto> findAllRecords() {
        return recordRepository.findAll().stream().map(recordMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).toList();
    }
}
