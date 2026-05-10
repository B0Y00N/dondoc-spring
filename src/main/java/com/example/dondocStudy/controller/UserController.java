package com.example.dondocStudy.controller;

import com.example.dondocStudy.dto.UserDto;
import com.example.dondocStudy.entity.MonthlyHistoryEntity;
import com.example.dondocStudy.entity.UserEntity;
import com.example.dondocStudy.repository.MonthlyHistoryRepository;
import com.example.dondocStudy.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final MonthlyHistoryRepository monthlyHistoryRepository;

    @Operation(summary = "전체 사용자 조회")
    @GetMapping("")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Operation(summary = "신규 사용자 추가")
    @PostMapping("/")
    public UserDto createUser(@RequestBody UserDto userDto) {
        // 1. DTO 데이터를 Entity로 옮겨 담습니다.

        System.out.println(userDto);
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserPassword(userDto.getUserPassword());
        userEntity.setName(userDto.getName());
        userEntity.setAge(userDto.getAge());
        userEntity.setCurrentPigLevel(userDto.getCurrentPigLevel());
        userEntity.setCurrentHouseLevel(userDto.getCurrentHouseLevel());
        userEntity.setMonthlyIncome(userDto.getMonthlyIncome());
        userEntity.setTargetExpenseRatio(userDto.getTargetExpenseRatio());

        // 2. 리포지토리를 통해 DB에 저장합니다.
        // 이때 리포지토리는 DB가 생성한 ID가 포함된 엔티티를 반환합니다.
        UserEntity savedEntity = userRepository.save(userEntity);

        // 3. 저장된 결과를 다시 DTO에 담아 클라이언트에게 응답합니다.
        // 생성된 ID를 클라이언트가 확인할 수 있도록 id 값을 세팅해 주는 것이 중요합니다.
        userDto.setId(savedEntity.getId());

        return userDto;
    }

    @Operation(summary = "월간 히스토리 조회")
    @GetMapping("/monthly-histories")
    public List<MonthlyHistoryEntity> getAllMonthlyHistories() { return monthlyHistoryRepository.findAll(); }
}