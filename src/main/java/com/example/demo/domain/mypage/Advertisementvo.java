package com.example.demo.domain.mypage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
//	@OneToMany(mappedBy = "advertisementvo", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	private List<Campaignvo> campaignList = new ArrayList<Campaignvo>();
}
