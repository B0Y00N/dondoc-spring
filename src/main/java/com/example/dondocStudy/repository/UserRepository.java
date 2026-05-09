package com.example.dondocStudy.repository;

import com.example.dondocStudy.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository{
    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    private final RowMapper<UserEntity> userRowMapper = new BeanPropertyRowMapper<>(UserEntity.class);

    public List<UserEntity> findAll() { return namedJdbcTemplate.query("select * from users", userRowMapper); }

    public  UserEntity save(UserEntity userEntity) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(userEntity);

        String sql = """
                INSERT INTO users (user_id, user_password, name, age, current_pig_level, current_house_level, monthly_income, target_expense_ratio) VALUES
                (:userId, :userPassword, :name, :age, :currentPigLevel, :currentHouseLevel, :monthlyIncome, :targetExpenseRatio)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedJdbcTemplate.update(sql, param, keyHolder, new String[]{"id"});

        if(keyHolder.getKey() != null) {
            userEntity.setId(keyHolder.getKey().longValue());
        }

        return userEntity;
    }
}
