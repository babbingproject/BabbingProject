package com.example.demo.vo;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class ReviewImage {
	@Autowired
	private int img_id;
	private int review_id;
	private String img;
	private String img_review;
	
}
