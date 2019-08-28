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
	private int putedCount;
	
//	@OneToMany(mappedBy = "advertisementvo", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	private List<Campaignvo> campaignList = new ArrayList<Campaignvo>();
}
