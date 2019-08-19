package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewRepository reviewRepo;
}
