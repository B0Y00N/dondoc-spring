package com.example.dondocStudy.repository;

import com.example.dondocStudy.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository{
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<UserEntity> userRowMapper = new BeanPropertyRowMapper<>(UserEntity.class);

    public List<UserEntity> findAll() { return jdbcTemplate.query("select * from users", userRowMapper); }

    public Optional<UserEntity> findByUserId(String userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try {
            // 표준 JdbcTemplate의 queryForObject 순서는 (String, RowMapper, Object... args)
            UserEntity user = jdbcTemplate.queryForObject(sql, userRowMapper, userId);
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public  UserEntity save(UserEntity userEntity) {
        String sql = """
                INSERT INTO users (user_id, user_password, name, age, current_pig_level, current_house_level, monthly_income, target_expense_ratio) VALUES
                (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});

            ps.setString(1, userEntity.getUserId());
            ps.setString(2, userEntity.getUserPassword());
            ps.setString(3, userEntity.getName());
            ps.setInt(4, userEntity.getAge());
            ps.setInt(5, userEntity.getCurrentPigLevel());
            ps.setInt(6, userEntity.getCurrentHouseLevel());
            ps.setLong(7, userEntity.getMonthlyIncome());
            ps.setInt(8, userEntity.getTargetExpenseRatio());

            return ps;
        }, keyHolder);

        if(keyHolder.getKey() != null) {
            userEntity.setId(keyHolder.getKey().longValue());
        }

        return userEntity;
    }
}
