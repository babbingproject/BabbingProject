package com.example.demo.domain.review;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.domain.mypage.Uservo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class ReviewRegistrationvo {
	@Id @GeneratedValue
	private int review_id;
	private String review_place;
	private String title;
	private String advantages;
	private String disadvantages;
	private Timestamp write_date;
	private Timestamp modified_date;
	private int reviewType_id;
	private int business_field_id;
	private int theme_id;
	
//	@ManyToOne
//	@JoinColumn(name="user_id", nullable=false)
//	private Uservo uservo;
}
