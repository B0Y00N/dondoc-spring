package com.example.dondocStudy.controller;

import com.example.dondocStudy.dto.UserDto;
import com.example.dondocStudy.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "User API", description = "사용자 정보 조회 API")
@RestController
@RequestMapping("/api/users") // 공통 경로 설정
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Operation(summary = "전체 사용자 조회")
    @GetMapping("")
    public List<UserDto.Info> getAllUsers() {
        return userRepository.findAllUsers().getUsers();
    }

    @Operation(summary = "월간 히스토리 조회")
    @GetMapping("/monthly-histories")
    public List<UserDto.MonthlyHistory> getAllMonthlyHistories() {
        return userRepository.findAllUsers().getMonthly_history();
    }
}