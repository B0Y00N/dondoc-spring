package com.example.dondocStudy.service;

import com.example.dondocStudy.dto.MonthlyHistoryDto;
import com.example.dondocStudy.dto.UserDto;
import com.example.dondocStudy.dto.auth.LoginRequest;

import java.util.List;

public interface UserService {

    // 로그인
    boolean login(LoginRequest loginRequest);

    // 회원가입
    UserDto join(UserDto userDto);

    // 전체 사용자 조회
    List<UserDto> findAllUsers();

    // 월간 히스토리 어카징...??
    // 전체 월간 히스토리 조회
    List<MonthlyHistoryDto> findAllMonthlyHistories();
}
