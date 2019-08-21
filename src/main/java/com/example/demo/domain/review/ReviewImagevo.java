package com.example.demo.domain.review;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class ReviewImagevo {
	@Id @GeneratedValue
	private int img_id;
	private int review_id;
	private String img;
	private String img_review;
}
