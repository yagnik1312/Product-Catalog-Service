package com.example.sprintbootapp.dto;

import com.example.sprintbootapp.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAndReviewDTO {
    private ProductDTO product;
    private List<ReviewDTO> reviews;
}
