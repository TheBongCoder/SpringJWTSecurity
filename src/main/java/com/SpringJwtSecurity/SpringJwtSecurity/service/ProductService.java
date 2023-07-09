package com.SpringJwtSecurity.SpringJwtSecurity.service;

import com.SpringJwtSecurity.SpringJwtSecurity.dto.ProductRequestDTO;
import com.SpringJwtSecurity.SpringJwtSecurity.dto.ProductResponseDTO;
import com.SpringJwtSecurity.SpringJwtSecurity.entity.Product;
import com.SpringJwtSecurity.SpringJwtSecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        Product productSaved = productRepository.save(product);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(productSaved.getName());
        productResponseDTO.setPrice(productSaved.getPrice());
        productResponseDTO.setId(productSaved.getId());
        return productResponseDTO;

    }
}
