package com.example.sprintbootapp.mapper;

import com.example.sprintbootapp.dto.ProductDTO;
import com.example.sprintbootapp.dto.ReviewDTO;
import com.example.sprintbootapp.model.Product;
import com.example.sprintbootapp.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review reviewDTOToReview(ReviewDTO r){
        Review entity = new Review();
        entity.setComment(r.getComment());
        return entity;
    }
}
