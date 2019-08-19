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
public class Campaignvo {
	@Id @GeneratedValue
	private int campaign_id;
	private String title;
	private String introduction;
	private int recruitment;
	private int participants;
	private Date start_date;
	private Date end_date;
	private String offer_history;
	private String remarks;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date write_date;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date modified_date;
	
	
}
