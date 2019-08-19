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
public class ReviewAlarm {
	@Id @GeneratedValue
	private int reviewAlarm_id;
	private String alarm_context;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmSend_time;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmReceive_time;
	private int advertisement_id;
	private int user_id;
	private int review_id;
}
