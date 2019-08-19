package com.example.demo.domain;

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

public class Likevo {
	@Id @GeneratedValue
	private int like_id;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date like_time;
	private int review_id;
	private int user_id;
	
}
