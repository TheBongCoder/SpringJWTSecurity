package com.SpringJwtSecurity.SpringJwtSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {

    private String accessToken;
}
