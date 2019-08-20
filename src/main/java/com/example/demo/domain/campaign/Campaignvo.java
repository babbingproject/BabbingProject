package com.example.demo.domain.campaign;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.domain.mypage.Advertisementvo;

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
	
	@ManyToOne
	@JoinColumn(name="advertisement_id", nullable=false)
	private Advertisementvo advertisementvo;
	
	
}
