package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository{
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<UserDto.Info> userRowMapper = new BeanPropertyRowMapper<>(UserDto.Info.class);
    private final RowMapper<UserDto.MonthlyHistory> monthlyHistoryRowMapper = new BeanPropertyRowMapper<>(UserDto.MonthlyHistory.class);

    public UserDto findAllUsers() {
        UserDto userDto = new UserDto();

        userDto.setUsers(jdbcTemplate.query("select * from users", userRowMapper));
        userDto.setMonthly_history(jdbcTemplate.query("select * from monthly_history", monthlyHistoryRowMapper));

        return userDto;
    }

}
