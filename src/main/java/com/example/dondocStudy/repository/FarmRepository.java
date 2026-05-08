package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.FarmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FarmRepository{
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<FarmDto.Info> infoRowMapper = new BeanPropertyRowMapper<>(FarmDto.Info.class);
    private final RowMapper<FarmDto.FarmMember> farmMemberRowMapper = new BeanPropertyRowMapper<>(FarmDto.FarmMember.class);

    public List<FarmDto.Info> findAllFarms() { return jdbcTemplate.query("select * from farms", infoRowMapper); }

    public List<FarmDto.FarmMember> findAllFarmMembers() { return jdbcTemplate.query("select * from farm_members", farmMemberRowMapper); }
}
