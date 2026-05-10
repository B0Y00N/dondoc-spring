package com.example.dondocStudy.service;

import com.example.dondocStudy.dto.MonthlyHistoryDto;
import com.example.dondocStudy.dto.UserDto;
import com.example.dondocStudy.entity.MonthlyHistoryEntity;
import com.example.dondocStudy.entity.UserEntity;
import com.example.dondocStudy.repository.MonthlyHistoryRepository;
import com.example.dondocStudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final MonthlyHistoryRepository monthlyHistoryRepository;

    @Override
    public UserDto join(UserDto userDto) {
        // DTO -> Entity 변환
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserPassword(userDto.getUserPassword());
        userEntity.setName(userDto.getName());
        userEntity.setAge(userDto.getAge());
        userEntity.setCurrentPigLevel(userDto.getCurrentPigLevel());
        userEntity.setCurrentHouseLevel(userDto.getCurrentHouseLevel());
        userEntity.setMonthlyIncome(userDto.getMonthlyIncome());
        userEntity.setTargetExpenseRatio(userDto.getTargetExpenseRatio());

        // Repository 레이어로 전달 및 답변 받아옴
        UserEntity savedEntity = userRepository.save(userEntity);

        // Entity -> DTO 변환
        userDto.setId(savedEntity.getId());

        return userDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> userDtoList = userEntityList.stream()
                .map(userEntity -> {
                    UserDto userDto = new UserDto();

                    userDto.setId(userEntity.getId());
                    userDto.setUserId(userEntity.getUserId());
                    userDto.setUserPassword(userEntity.getUserPassword());
                    userDto.setAge(userEntity.getAge());
                    userDto.setName(userEntity.getName());
                    userDto.setMonthlyIncome(userEntity.getMonthlyIncome());
                    userDto.setCurrentHouseLevel(userEntity.getCurrentHouseLevel());
                    userDto.setCurrentPigLevel(userEntity.getCurrentPigLevel());
                    userDto.setTargetExpenseRatio(userEntity.getTargetExpenseRatio());

                    return userDto;
                }).toList();

        return userDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MonthlyHistoryDto> findAllMonthlyHistories() {
        List<MonthlyHistoryEntity> monthlyHistoryEntityList = monthlyHistoryRepository.findAll();
        List<MonthlyHistoryDto> monthlyHistoryDtoList = monthlyHistoryEntityList.stream()
                .map(monthlyHistoryEntity -> {
                    MonthlyHistoryDto monthlyHistoryDto = new MonthlyHistoryDto();

                    monthlyHistoryDto.setId(monthlyHistoryEntity.getId());
                    monthlyHistoryDto.setUserId(monthlyHistoryEntity.getUserId());
                    monthlyHistoryDto.setHouseLevel(monthlyHistoryEntity.getHouseLevel());
                    monthlyHistoryDto.setAvgRatio(monthlyHistoryEntity.getAvgRatio());
                    monthlyHistoryDto.setTargetMonth(monthlyHistoryEntity.getTargetMonth());

                    return monthlyHistoryDto;
                }).toList();

        return monthlyHistoryDtoList;
    }
}
