package com.example.demo.domain;

import java.sql.Timestamp;

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
public class ScrapVO {
	@Id @GeneratedValue
	private int scrap_id;
	private Timestamp scrap_time;
	private int review_id;
	private int user_id;
	
}
