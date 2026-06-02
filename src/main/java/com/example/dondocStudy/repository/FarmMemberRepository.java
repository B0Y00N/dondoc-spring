package com.example.dondocStudy.repository;

import com.example.dondocStudy.entity.FarmMemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FarmMemberRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<FarmMemberEntity> farmMemberRowMapper = new BeanPropertyRowMapper<>(FarmMemberEntity.class);

    public List<FarmMemberEntity> findAll() { return jdbcTemplate.query("select * from farm_members", farmMemberRowMapper); }
}
