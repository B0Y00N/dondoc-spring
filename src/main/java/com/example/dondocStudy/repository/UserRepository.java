package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class UserRepository{
    private final ObjectMapper objectMapper = new ObjectMapper();

    // db.json 파일을 읽어 UserDto 객체로 변환하는 메서드
    public UserDto findAllUsers() throws IOException {
        ClassPathResource resource = new ClassPathResource("db.json");
        return objectMapper.readValue(resource.getInputStream(), UserDto.class);
    }
}
