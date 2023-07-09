package com.SpringJwtSecurity.SpringJwtSecurity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "name cannot be blank")
    private String name;

    private long price;
}
