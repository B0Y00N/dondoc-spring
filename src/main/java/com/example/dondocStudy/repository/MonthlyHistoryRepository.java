package com.example.dondocStudy.repository;

import com.example.dondocStudy.entity.MonthlyHistoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MonthlyHistoryRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<MonthlyHistoryEntity> monthlyHistoryRowMapper = new BeanPropertyRowMapper<>(MonthlyHistoryEntity.class);

    public List<MonthlyHistoryEntity> findAll() { return jdbcTemplate.query("select * from monthly_history", monthlyHistoryRowMapper); }
}
