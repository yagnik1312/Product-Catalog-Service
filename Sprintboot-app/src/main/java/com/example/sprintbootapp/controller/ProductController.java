package com.example.sprintbootapp.controller;

import com.example.sprintbootapp.dto.ProductDTO;
import com.example.sprintbootapp.model.Product;
import com.example.sprintbootapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
            return service.getMessage();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productData) {
        ProductDTO product = service.save(productData);
        return ResponseEntity.ok(product);
    }

}
