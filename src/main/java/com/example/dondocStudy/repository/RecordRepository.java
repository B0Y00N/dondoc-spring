package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.RecordDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RecordRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<RecordDto.Info> infoRowMapper = (rs, rowNum) -> {
        RecordDto.Info info = new RecordDto.Info();

        info.setId(rs.getLong("id"));
        info.setUser_id(rs.getLong("user_id"));
        info.setAmount(rs.getLong("amount"));
        info.setCategory_id(rs.getLong("category_id"));
        info.setMemo(rs.getString("memo"));
        info.setDescription(rs.getString("description"));
        info.setRecord_date(rs.getString("record_date"));
        info.setCreated_at(rs.getString("created_at"));

        return info;
    };
    private final RowMapper<RecordDto.CategoryInfo> categoryInfoRowMapper = (rs, rowNum) -> {
        RecordDto.CategoryInfo categoryInfo = new RecordDto.CategoryInfo();

        categoryInfo.setId(rs.getLong("id"));
        categoryInfo.setIcon(rs.getString("icon"));
        categoryInfo.setName(rs.getString("name"));
        categoryInfo.setType(rs.getString("type"));

        return categoryInfo;
    };

    public RecordRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RecordDto findAllRecords() {
        RecordDto recordDto = new RecordDto();

        recordDto.setRecords(jdbcTemplate.query("select * from records", infoRowMapper));
        recordDto.setCategories(jdbcTemplate.query("select * from categories", categoryInfoRowMapper));

        return recordDto;
    }
}
