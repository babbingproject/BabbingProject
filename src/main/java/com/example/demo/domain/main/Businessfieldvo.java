package com.example.demo.domain.main;

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

public class Businessfieldvo {

	@Id @GeneratedValue
	private int business_field_id;
	private String business_field_code;
	private String business_field_wes;
	private String business_field_jpn;
	private String business_field_chn;
	private String business_field_ind;
	private String business_field_sea;
	private String business_field_snk;
	private String business_field_paz;
	private String business_field_chk;
	private String business_field_fst;
}
