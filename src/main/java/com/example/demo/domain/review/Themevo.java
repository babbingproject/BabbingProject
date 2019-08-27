package com.example.demo.domain.review;

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
public class Themevo {

	@Id @GeneratedValue
	private int themeId;
	private String themeDpt;
	private String themeDth;
	private String themeFmt;
	private String themeDte;
	private String themeInm;
	private String themeSgm;
	private String themeTvr;
	private String themeRnd;
	private String themeEff;
	private String themeSpc;
	private String themeFoc;
	private String themeBef;
	private String themeChm;
	private String themeEtc;
}
