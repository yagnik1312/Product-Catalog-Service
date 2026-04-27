package com.example.sprintbootapp.repository;

import com.example.sprintbootapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
