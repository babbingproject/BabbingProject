package com.example.demo.vo;

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
public class ThemeVO {

	@Id @GeneratedValue
	private int theme_id;
	private String theme_dpt;
	private String theme_bth;
	private String theme_fmt;
	private String theme_dte;
	private String theme_inm;
	private String theme_sgm;
	private String theme_tvr;
	private String theme_rnd;
	private String theme_eff;
	private String theme_spc;
	private String theme_foc;
	private String theme_bef;
	private String theme_chm;
	private String theme_etc;
}
