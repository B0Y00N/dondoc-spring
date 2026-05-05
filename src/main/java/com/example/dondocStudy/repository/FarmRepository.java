package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.FarmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FarmRepository{
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<FarmDto.Info> infoRowMapper = new BeanPropertyRowMapper<>(FarmDto.Info.class);
    private final RowMapper<FarmDto.FarmMember> farmMemberRowMapper = new BeanPropertyRowMapper<>(FarmDto.FarmMember.class);

    public FarmDto findAllFarms() {
        FarmDto farmDto = new FarmDto();

        farmDto.setFarms(jdbcTemplate.query("select * from farms", infoRowMapper));
        farmDto.setFarm_members(jdbcTemplate.query("select * from farm_members", farmMemberRowMapper));

        return farmDto;
    }
}
