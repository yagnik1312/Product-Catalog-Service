package com.example.sprintbootapp.service;

import com.example.sprintbootapp.model.Product;
import com.example.sprintbootapp.model.Review;
import com.example.sprintbootapp.repository.ProductRepository;
import com.example.sprintbootapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ProductRepository productRepository;

    private final ReviewRepository repository;
    public ReviewService(ReviewRepository repository){
        this.repository = repository;
    }

   public List<Review> getReviews(){
        return repository.findAll();
   }

    public Review save(Review review, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        review.setProduct(product);
        return repository.save(review);
    }

}
