package com.example.demo.domain.mypage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.domain.review.ReviewRegistrationvo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Uservo {

	@Id @GeneratedValue
	private int user_id;
	private String user_email;
	private String nickname;
	private String password;
	private String introduce;
	private String profile_img;
	private int put_count;
	private int following_count;
	private int sns_factor;
	private int favor_factor;
	private int scrap_factor;
	private int post_count;
	private int comment_count;
	private int user_score;
	private int total_count;
	private String u_rank_img1;
	private String u_rank_img2;
	private String u_rank_img3;
	private String u_rank_img4;
	private String u_rank_img5;
	
	@OneToMany(mappedBy="uservo", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<ReviewRegistrationvo> reviewRegistrationList = new ArrayList<ReviewRegistrationvo>(); 
}
