package com.example.sprintbootapp.service;

import com.example.sprintbootapp.mapper.ProductMapper;
import com.example.sprintbootapp.model.Product;
import com.example.sprintbootapp.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
    }


    public String getMessage() {
        return "Product Service Working";
    }
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return repository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public Product save(Product product) {
        return repository.save(product);
    }
}
