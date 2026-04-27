package com.example.sprintbootapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    @NotBlank(message = "Comment is required")
    private String comment;

    @NotNull(message = "productId is required")
    private Long productId;
}
