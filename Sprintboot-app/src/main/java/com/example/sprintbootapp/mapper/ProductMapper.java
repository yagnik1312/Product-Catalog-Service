package com.example.sprintbootapp.mapper;

import com.example.sprintbootapp.dto.ProductDTO;
import com.example.sprintbootapp.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product productDTOToProduct(ProductDTO p){
        Product entity = new Product();
        entity.setName(p.getName());
        entity.setPrice(p.getPrice());
        return entity;
    }
}
