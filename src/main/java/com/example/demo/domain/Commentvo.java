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

public class Commentvo {
	@Id @GeneratedValue
	private int comment_id;
	private String contents;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date write_date;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date modified_date;
	private int user_id;
	private int review_id;
}
