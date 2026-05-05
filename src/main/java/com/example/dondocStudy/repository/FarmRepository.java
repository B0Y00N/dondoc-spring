package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.FarmDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FarmRepository{
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<FarmDto.info> infoRowMapper = (rs, rowNum) -> {
        FarmDto.info info = new FarmDto.info();

        info.setId(rs.getLong("id"));
        info.setName(rs.getString("name"));
        info.setCreated_at(rs.getString("created_at"));

        return info;
    };
    private final RowMapper<FarmDto.FarmMember> farmMemberRowMapper = (rs, rowNum) -> {
        FarmDto.FarmMember farmMember = new FarmDto.FarmMember();

        farmMember.setId(rs.getLong("id"));
        farmMember.setFarm_id(rs.getLong("farm_id"));
        farmMember.setUser_id(rs.getLong("user_id"));
        farmMember.setJoined_at(rs.getString("joined_at"));

        return farmMember;
    };

    public FarmRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public FarmDto findAllFarms() {
        FarmDto farmDto = new FarmDto();

        farmDto.setFarms(jdbcTemplate.query("select * from farms", infoRowMapper));
        farmDto.setFarm_members(jdbcTemplate.query("select * from farm_members", farmMemberRowMapper));

        return farmDto;
    }
}
