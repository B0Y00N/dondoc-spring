package com.example.dondocStudy.service;

import com.example.dondocStudy.dto.MonthlyHistoryDto;
import com.example.dondocStudy.dto.UserDto;
import com.example.dondocStudy.entity.UserEntity;
import com.example.dondocStudy.mapper.MonthlyHistoryMapper;
import com.example.dondocStudy.mapper.UserMapper;
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
    private final UserMapper userMapper;
    private final MonthlyHistoryMapper monthlyHistoryMapper;

    @Override
    public UserDto join(UserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);

        UserEntity savedEntity = userRepository.save(userEntity);

        userDto.setId(savedEntity.getId());

        return userDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MonthlyHistoryDto> findAllMonthlyHistories() {
        return monthlyHistoryRepository.findAll().stream().map(monthlyHistoryMapper::toDto).toList();
    }
}
