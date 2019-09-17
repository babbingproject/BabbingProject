package com.example.demo.utils;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.domain.review.ReviewImagevo;
import com.example.demo.domain.review.ReviewRegistrationvo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPaging {
	
	List<ReviewRegistrationvo> reviewRegistrationvo;
	ReviewImagevo reviewImagevo;
	Page<ReviewRegistrationvo> reviewRegistrationvoPage;
	String reviewImage;
	Object[] review;
	
}
