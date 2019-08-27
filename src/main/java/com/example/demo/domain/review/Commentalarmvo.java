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
	private int commentAlarmId;
	private String alarmContext;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmSendTime;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date alarmReceiveTime;
	private int commentId;
	private int userId;
	private int advertisementId;
	
}
