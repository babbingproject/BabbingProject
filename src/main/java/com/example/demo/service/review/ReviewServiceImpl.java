package com.example.demo.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.review.ReviewRegistrationvo;

@Service
public class ReviewServiceImpl implements ReviewService  {
	@Autowired
	ReviewRepository reviewRepo;
	
}
