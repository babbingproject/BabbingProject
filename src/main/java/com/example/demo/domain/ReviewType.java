package com.example.demo.domain;

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
public class ReviewType {
	@Id @GeneratedValue
	private int reviewType_id;
	private int review_type1;
	private int review_type2;
	
}
