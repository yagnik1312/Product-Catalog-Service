package com.example.sprintbootapp.controller;

import com.example.sprintbootapp.dto.ProductAndReviewDTO;
import com.example.sprintbootapp.dto.ProductDTO;
import com.example.sprintbootapp.mapper.ProductMapper;
import com.example.sprintbootapp.mapper.ReviewMapper;
import com.example.sprintbootapp.model.Product;
import com.example.sprintbootapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ReviewMapper reviewMapper;

    public ProductController() {
    }

    @GetMapping("/test")
    public String test() {
            return service.getMessage();
    }

    @GetMapping("/products")
    public Page<Product> getAllProducts( @RequestParam(defaultValue = "0") int pageNumber,
                                         @RequestParam(defaultValue = "10") int pageSize) {
        return service.getAllProducts(pageNumber, pageSize);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productData) {
        Product product = service.save(mapper.productDTOToProduct(productData));
        return ResponseEntity.ok(product);
    }
    @PostMapping("/products-review")
    public ResponseEntity<Product> createProductAndReview(@Valid @RequestBody ProductAndReviewDTO productAndReviewData) {
        Product product = service.createProductWithReviews(mapper.productDTOToProduct(productAndReviewData.getProduct()),
                productAndReviewData.getReviews().stream()
                        .map(reviewMapper::reviewDTOToReview)
                        .toList()
        );
        return ResponseEntity.ok(product);
    }

}
