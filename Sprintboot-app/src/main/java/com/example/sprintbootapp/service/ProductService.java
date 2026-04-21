package com.example.sprintbootapp.service;

import com.example.sprintbootapp.dto.ProductDTO;
import com.example.sprintbootapp.mapper.ProductMapper;
import com.example.sprintbootapp.model.Product;
import com.example.sprintbootapp.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
    }


    public String getMessage() {
        return "Product Service Working";
    }
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }
}
