package com.example.dondocStudy.repository;

import com.example.dondocStudy.dto.DataDto;

import java.io.IOException;

public interface DataRepository {
    DataDto loadAllData() throws IOException;
}
