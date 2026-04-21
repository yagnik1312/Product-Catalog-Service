package com.example.sprintbootapp.repository;

import com.example.sprintbootapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
