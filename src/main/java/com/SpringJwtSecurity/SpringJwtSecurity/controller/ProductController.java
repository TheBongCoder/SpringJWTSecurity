package com.SpringJwtSecurity.SpringJwtSecurity.controller;

import com.SpringJwtSecurity.SpringJwtSecurity.dto.ProductRequestDTO;
import com.SpringJwtSecurity.SpringJwtSecurity.dto.ProductResponseDTO;
import com.SpringJwtSecurity.SpringJwtSecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
        URI productURI = URI.create("/products/" + productResponseDTO.getId());
        return ResponseEntity.created(productURI).body(productResponseDTO);

    }
}
