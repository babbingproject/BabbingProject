package com.example.demo.service.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewRegistrationvo;

public interface CommentRepository extends JpaRepository<Commentvo, Integer> {

	List<Commentvo> findByReviewRegistrationvo(ReviewRegistrationvo reviewRegistrationvo);

}
