package com.example.demo.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ReviewController;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewController reviewRepo;
}
