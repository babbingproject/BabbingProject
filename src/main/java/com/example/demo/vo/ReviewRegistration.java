package com.example.demo.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class ReviewRegistration {
	@Id @GeneratedValue
	private int review_id;
	private String review_place;
	private String title;
	private String advantages;
	private String disadvantages;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date write_date;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date modified_date;
	private int user_id;
	private int reviewType_id;
	private int business_field_id;
	private int theme_id;
}
