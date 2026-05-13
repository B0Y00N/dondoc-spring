package com.example.dondocStudy.repository;

import com.example.dondocStudy.entity.RecordEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RecordRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<RecordEntity> rowMapper = new BeanPropertyRowMapper<>(RecordEntity.class);

    public List<RecordEntity> findAll() { return jdbcTemplate.query("select * from records", rowMapper); }

    public List<RecordEntity> findRecords(long userId) {
        String sql = "SELECT * FROM records WHERE user_id = :userId";
        Map<String, Object> param = Map.of("userId", userId);

        try {
            List<RecordEntity> records = jdbcTemplate.query(sql, param, rowMapper);
            return  records;
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
