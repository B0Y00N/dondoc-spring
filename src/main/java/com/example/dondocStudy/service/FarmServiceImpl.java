package com.example.dondocStudy.service;

import com.example.dondocStudy.dto.FarmDto;
import com.example.dondocStudy.dto.FarmMemberDto;
import com.example.dondocStudy.mapper.FarmMapper;
import com.example.dondocStudy.mapper.FarmMemberMapper;
import com.example.dondocStudy.repository.FarmMemberRepository;
import com.example.dondocStudy.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService{
    private final FarmRepository farmRepository;
    private final FarmMemberRepository farmMemberRepository;
    private final FarmMapper farmMapper;
    private final FarmMemberMapper farmMemberMapper;

    @Override
    @Transactional(readOnly = true)
    public List<FarmDto> findAllFarms() {
        return farmRepository.findAll().stream().map(farmMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<FarmMemberDto> findAllFarmMembers() {
        return farmMemberRepository.findAll().stream().map(farmMemberMapper::toDto).toList();
    }
}
