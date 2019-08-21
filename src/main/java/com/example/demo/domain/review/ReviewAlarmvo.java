package com.example.demo.domain.review;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class ReviewAlarmvo {

	@Id @GeneratedValue
	private int reviewAlarm_id;
	private String alarm_context;
	private Date alarmSend_time;
	private Date alarmReceive_time;
	private int advertisement_id;
	private int user_id;
	private int review_id;
}
