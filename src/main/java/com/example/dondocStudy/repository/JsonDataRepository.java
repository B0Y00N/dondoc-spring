package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.DataDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class JsonDataRepository implements DataRepository{
    private final ObjectMapper objectMapper = new ObjectMapper();

    // db.json 파일을 읽어 DataDto 객체로 변환하는 공통 메서드
    @Override
    public DataDto loadAllData() throws IOException {
        ClassPathResource resource = new ClassPathResource("db.json");
        return objectMapper.readValue(resource.getInputStream(), DataDto.class);
    }
}
