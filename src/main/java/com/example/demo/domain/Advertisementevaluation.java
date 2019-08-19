package com.example.demo.domain;

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
public class Advertisementevaluation {

	@Id @GeneratedValue
	private int evaluation_id;
	private float flavor;
	private float price;
	private float service;
	private float convenience;
	private float envaluation_avg;
	private String evaluation_comment;
	private String merit;
	private String demerit;
	private int advertisement_id;
	
	
}
