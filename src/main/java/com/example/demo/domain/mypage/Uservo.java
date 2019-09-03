package com.example.demo.domain.mypage;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewRegistrationvo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Uservo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	private String nickname;
	private String password;
	private String introduce;
	private String userPhone;
	private String userKey;// 인증번호
	private String userEmail;
	@Column(nullable = true)
	private String profileImg;
	@Column(nullable = true)
	private Integer putCount;
	@Column(nullable = true)
	private Integer followingCount;
	@Column(nullable = true)
	private Integer snsFactor;
	@Column(nullable = true)
	private Integer favorFactor;
	@Column(nullable = true)
	private Integer scrapFactor;
	@Column(nullable = true)
	private Integer postCount;
	@Column(nullable = true)
	private Integer commentCount;
	@Column(nullable = true)
	private Integer userScore;
	@Column(nullable = true)
	private Integer totalCount;
	@Column(nullable = true)
	private String uRankImg1;
	private String uRankImg2;
	private String uRankImg3;
	private String uRankImg4;
	private String uRankImg5;
	// 세션 테스트용 임시컬럼
	private String role;

	@OneToMany(mappedBy = "uservo", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReviewRegistrationvo> reviewRegistrationList = new ArrayList<ReviewRegistrationvo>();

	@OneToMany(mappedBy = "uservo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Commentvo> CommentList = new ArrayList<Commentvo>();

//	@OneToMany(mappedBy="Uservo", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	private List<ReviewRegistrationvo> reviewRegistrationList = new ArrayList<ReviewRegistrationvo>(); 
}
