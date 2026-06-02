package com.example.dondocStudy.controller;

import com.example.dondocStudy.dto.MonthlyHistoryDto;
import com.example.dondocStudy.dto.UserDto;
import com.example.dondocStudy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User API", description = "사용자 정보 조회 API")
@RestController
@RequestMapping("/api/users") // 공통 경로 설정
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "전체 사용자 조회")
    @GetMapping("")
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @Operation(summary = "신규 사용자 추가")
    @PostMapping("")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.join(userDto);
    }

    @Operation(summary = "월간 히스토리 조회")
    @GetMapping("/monthly-histories")
    public List<MonthlyHistoryDto> getAllMonthlyHistories() { return userService.findAllMonthlyHistories(); }
}