package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.RecordDto;
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
    private final RowMapper<RecordDto.Info> infoRowMapper = new BeanPropertyRowMapper<>(RecordDto.Info.class);
    private final RowMapper<RecordDto.CategoryInfo> categoryInfoRowMapper = new BeanPropertyRowMapper<>(RecordDto.CategoryInfo.class);

    public List<RecordDto.Info> findAllRecords() { return jdbcTemplate.query("select * from records", infoRowMapper); }

    public List<RecordDto.CategoryInfo> findAllCategories() { return jdbcTemplate.query("select * from categories", categoryInfoRowMapper); }
}
