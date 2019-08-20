package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.ReviewRegistration;

public interface ReviewRepository extends JpaRepository<ReviewRegistration, Integer>{

}
