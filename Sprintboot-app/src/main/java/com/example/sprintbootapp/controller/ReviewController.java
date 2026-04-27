package com.example.sprintbootapp.controller;

import com.example.sprintbootapp.dto.ReviewDTO;
import com.example.sprintbootapp.mapper.ReviewMapper;
import com.example.sprintbootapp.model.Review;
import com.example.sprintbootapp.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService service;

    @Autowired
    private ReviewMapper mapper;

    @GetMapping("/review")
    public List<Review> getAllReviews() {
        return service.getReviews();
    }

    @PostMapping("/review")
    public ResponseEntity<Review> createReview(@Valid @RequestBody ReviewDTO reviewData) {
        Review review = mapper.reviewDTOToReview(reviewData);

        Review saved = service.save(review, reviewData.getProductId());
        return ResponseEntity.ok(saved);
    }
}
