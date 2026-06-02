package com.example.dondocStudy.repository;

import com.example.dondocStudy.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<CategoryEntity> categoryInfoRowMapper = new BeanPropertyRowMapper<>(CategoryEntity.class);

    public List<CategoryEntity> findAll() { return jdbcTemplate.query("select * from categories", categoryInfoRowMapper); }
}
