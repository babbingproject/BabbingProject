package com.example.demo.domain.campaign;

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
public class Campaignalarmvo {

	@Id @GeneratedValue
	private int campaignAlarm_id;
	private String alarm_context;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmSend_time;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmReceive_time;
	private int advertisement_id;
	private int user_id;
	private int campaign_id;
	
	
}
