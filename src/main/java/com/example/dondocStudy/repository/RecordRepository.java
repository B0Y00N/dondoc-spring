package com.example.dondocStudy.repository;

import com.example.dondocStudy.entity.RecordEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecordRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<RecordEntity> infoRowMapper = new BeanPropertyRowMapper<>(RecordEntity.class);

    public List<RecordEntity> findAll() { return jdbcTemplate.query("select * from records", infoRowMapper); }
}
