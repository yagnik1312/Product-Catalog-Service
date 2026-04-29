package com.example.sprintbootapp.service;

import com.example.sprintbootapp.mapper.ProductMapper;
import com.example.sprintbootapp.model.Product;
import com.example.sprintbootapp.model.Review;
import com.example.sprintbootapp.repository.ProductRepository;
import com.example.sprintbootapp.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository repository;
    private final ReviewRepository reviewRepository;

    public ProductService(ProductRepository repository, ReviewRepository reviewRepository) {
        this.repository = repository;
        this.reviewRepository = reviewRepository;
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

    @Transactional
    public Product createProductWithReviews(Product product, List<Review> reviews) {
        Product savedProduct = repository.save(product);
        if (reviews == null || reviews.isEmpty()) {
            throw new RuntimeException("Reviews list cannot be empty");
        }

        for (Review review : reviews) {
            review.setProduct(savedProduct);
        }
        reviewRepository.saveAll(reviews);
        return savedProduct;

    }

}
