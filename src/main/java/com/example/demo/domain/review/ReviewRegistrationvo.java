package com.example.demo.domain.review;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private int business_field_id;
	private int theme_id;
	
//	@ManyToOne
//	@JoinColumn(name="user_id", nullable=false)
//	private Uservo uservo;
	
	@OneToMany(mappedBy="review_id", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<ReviewImagevo> reviewImagevoList = new ArrayList<ReviewImagevo>();
}
