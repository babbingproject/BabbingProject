package com.example.demo.domain.campaign;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Campaignimgvo {

	@Id @GeneratedValue
	private int campaignImg_id;
	private String campaign_Img;
	private int campaign_id;
	
}
