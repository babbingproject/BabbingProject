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
public class Advertisementvo {

	@Id @GeneratedValue
	private int advertisement_id;
	private String advertisement_email;
	private String advertisement_name;
	private String password;
	private String introduce;
	private String advertisement_num;
	private String address;
	private String profile_img;
	private String non_members_com;
	private String non_members_address;
	private int puted_count;
	
}