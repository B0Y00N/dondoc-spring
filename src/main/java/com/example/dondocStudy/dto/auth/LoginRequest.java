package com.example.dondocStudy.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginRequest {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_password")
    private String userPassword;
}
