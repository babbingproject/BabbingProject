package com.example.demo.domain.campaign;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private int campaignId;
	private String title;
	private String introduction;
	private int recruitment;
	private int participants;
	private Date startDate;
	private Date endDate;
	private String offerHistory;
	private String remarks;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date writeDate;
	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date modifiedDate;

	
	@ManyToOne
	@JoinColumn(name="advertisement_id", nullable=false)
	private Advertisementvo advertisementvo;
	
	
}
