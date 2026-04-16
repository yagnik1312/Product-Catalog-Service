package com.example.sprintbootapp.service;

import com.example.sprintbootapp.dto.ProductDTO;
import com.example.sprintbootapp.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public String getMessage() {
        return "Product Service Working";
    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L,"Laptop",80));
        products.add(new Product(2L,"Mobile",30));
        products.add(new Product(3L,"IPhone",120));
        products.add(new Product(4L,"Samsung",90));
        return products;
    }

    public ProductDTO save(ProductDTO product) {
        return product;
    }
}
