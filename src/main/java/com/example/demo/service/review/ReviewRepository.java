package com.example.demo.service.review;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.review.ReviewRegistrationvo;

public interface ReviewRepository extends JpaRepository<ReviewRegistrationvo, Integer>{

}
