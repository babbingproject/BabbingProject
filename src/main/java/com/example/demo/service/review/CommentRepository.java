package com.example.demo.service.review;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.review.Commentvo;

public interface CommentRepository extends JpaRepository<Commentvo, Integer> {

}
