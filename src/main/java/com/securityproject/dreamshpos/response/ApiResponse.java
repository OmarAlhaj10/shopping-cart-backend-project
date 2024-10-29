package com.securityproject.dreamshpos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    public String message;
    private Object data;
}
