package com.example.dondocStudy.service;

import com.example.dondocStudy.dto.CategoryDto;
import com.example.dondocStudy.dto.RecordDto;
import com.example.dondocStudy.dto.RecordRequest;
import com.example.dondocStudy.mapper.CategoryMapper;
import com.example.dondocStudy.mapper.RecordMapper;
import com.example.dondocStudy.repository.CategoryRepository;
import com.example.dondocStudy.repository.RecordRepository;
import com.example.dondocStudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService{
    private final RecordRepository recordRepository;
    private final CategoryRepository categoryRepository;
    private final RecordMapper recordMapper;
    private final CategoryMapper categoryMapper;

    // 쓰으으ㅡ으읍...
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RecordDto> findAllRecords() {
        return recordRepository.findAll().stream().map(recordMapper::toDto).toList();
    }

    @Override
    public List<RecordDto> findRecords(RecordRequest recordRequest) {
        long id = userRepository.findByUserId(recordRequest.getUserId())
                .map(userEntity -> userEntity.getId())
                .orElse(-1L);

        if(id != -1L) {
            return recordRepository.findRecords(id).stream().map(recordMapper::toDto).toList();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).toList();
    }
}
