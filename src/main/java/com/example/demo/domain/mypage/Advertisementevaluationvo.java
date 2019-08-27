package com.example.demo.domain.mypage;

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
public class Advertisementevaluationvo {

	@Id @GeneratedValue
	private int evaluationId;
	private float flavor;
	private float price;
	private float service;
	private float convenience;
	private float envaluationAvg;
	private String evaluationComment;
	private String merit;
	private String demerit;
	private int advertisementId;
	
	
}
