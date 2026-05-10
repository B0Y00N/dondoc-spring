package com.example.dondocStudy.repository;

import com.example.dondocStudy.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository{
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<UserEntity> userRowMapper = new BeanPropertyRowMapper<>(UserEntity.class);

    public List<UserEntity> findAll() { return jdbcTemplate.query("select * from users", userRowMapper); }

    public UserEntity save(UserEntity userEntity) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("users")
                .usingGeneratedKeyColumns("id", "created_at");

        SqlParameterSource param = new BeanPropertySqlParameterSource(userEntity);
        Number newId = jdbcInsert.executeAndReturnKey(param);

        userEntity.setId(newId.longValue());

        return userEntity;
    }
}
