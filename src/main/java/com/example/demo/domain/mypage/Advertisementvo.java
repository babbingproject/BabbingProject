package com.example.demo.domain.mypage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.domain.campaign.Campaignvo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Advertisementvo {

	@Id @GeneratedValue
	private int advertisementId;
	private String advertisementEmail;
	private String advertisementName;
	private String password;
	private String introduce;
	private String advertisementNum;
	private String address;
	private String profileImg;
	private String nonMembersCom;
	private String nonMembersAddress;
	
	@Column(nullable = false, columnDefinition="int default 0")
	private int putedCount;
	
	@Column( columnDefinition="float default 0")
	private float flavor;					// 맛
	@Column( columnDefinition="float default 0")
	private float service;					// 서비스
	@Column( columnDefinition="float default 0")
	private float convenience;				// 편의
	@Column( columnDefinition="float default 0")
	private float price;					// 가성비
	@Column( columnDefinition="float default 0")
	private float evaluation_avg;			// 업체 평점	
	
	@OneToMany(mappedBy = "advertisementvo", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Campaignvo> campaignList = new ArrayList<Campaignvo>();
}
