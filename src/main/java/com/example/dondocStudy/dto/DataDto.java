package com.example.dondocStudy.dto;

import lombok.Data;
import java.util.List;

@Data
public class DataDto {
    private List<UserDto.Info> users;
    private List<FarmDto.info> farms;
    private List<FarmDto.FarmMember> farm_members;
    private List<RecordDto.CategoryInfo> categories;
    private List<RecordDto.Info> records;
    private List<UserDto.MonthlyHistory> monthly_history;
}