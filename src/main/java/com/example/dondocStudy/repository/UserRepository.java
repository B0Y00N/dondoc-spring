package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository{
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<UserDto.Info> userRowMapper = new BeanPropertyRowMapper<>(UserDto.Info.class);
    private final RowMapper<UserDto.MonthlyHistory> monthlyHistoryRowMapper = new BeanPropertyRowMapper<>(UserDto.MonthlyHistory.class);

    public List<UserDto.Info> findAllUsers() { return jdbcTemplate.query("select * from users", userRowMapper); }

    public List<UserDto.MonthlyHistory> findAllMonthlyHistories() { return jdbcTemplate.query("select * from monthly_history", monthlyHistoryRowMapper); }
}
