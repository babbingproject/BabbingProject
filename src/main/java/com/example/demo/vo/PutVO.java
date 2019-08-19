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
public class PutVO {

	@Id @GeneratedValue
	private int put_id;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date put_time;
	private int advertisement_id;
	private int user_id;
}
