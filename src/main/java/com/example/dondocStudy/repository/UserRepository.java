package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository{
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<UserDto.Info> userRowMapper = (rs, rowNum) -> {
        UserDto.Info info = new UserDto.Info();

        info.setId(rs.getLong("id"));
        info.setUser_id(rs.getString("user_id"));
        info.setUser_password(rs.getString("user_password"));
        info.setName(rs.getString("name"));
        info.setAge(rs.getInt("age"));
        info.setCurrent_pig_level(rs.getInt("current_pig_level"));
        info.setCurrent_house_level(rs.getInt("current_house_level"));
        info.setMonthly_income(rs.getLong("monthly_income"));
        info.setTarget_expense_ratio(rs.getInt("target_expense_ratio"));
        info.setCreated_at(rs.getString("created_at"));

        return info;
    };
    private final RowMapper<UserDto.MonthlyHistory> monthlyHistoryRowMapper = (rs, rowNum) -> {
        UserDto.MonthlyHistory monthlyHistory = new UserDto.MonthlyHistory();

        monthlyHistory.setId(rs.getLong("id"));
        monthlyHistory.setUser_id(rs.getLong("user_id"));
        monthlyHistory.setTarget_month(rs.getString("target_month"));
        monthlyHistory.setAvg_ratio(rs.getDouble("avg_ratio"));
        monthlyHistory.setHouse_level(rs.getInt("house_level"));

        return monthlyHistory;
    };

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserDto findAllUsers() {
        UserDto userDto = new UserDto();

        userDto.setUsers(jdbcTemplate.query("select * from users", userRowMapper));
        userDto.setMonthly_history(jdbcTemplate.query("select * from monthly_history", monthlyHistoryRowMapper));

        return userDto;
    }

}
