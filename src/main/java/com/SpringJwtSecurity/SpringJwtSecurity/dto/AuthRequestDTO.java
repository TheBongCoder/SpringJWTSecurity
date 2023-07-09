package com.SpringJwtSecurity.SpringJwtSecurity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AuthRequestDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
