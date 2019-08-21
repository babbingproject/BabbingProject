package com.example.demo.domain.review;

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
public class Commentalarmvo {
	@Id @GeneratedValue
	private int commentAlarm_id;
	private String alarm_context;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmSend_time;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmReceive_time;
	private int comment_id;
	private int user_id;
	private int advertisement_id;
	
}
