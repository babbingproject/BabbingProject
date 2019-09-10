package com.example.demo.domain.mypage;


import java.util.ArrayList;
import java.util.Date;
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
@ToString(exclude = {"reviewRegistrationList", "commentList"})
@Entity
public class Uservo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String nickname;
	private String password;
	private String introduce;
	private String userPhone;
	@Column(name = "user_key")
	private String user_key;// 인증번호
	@Column(name = "user_email")
	private String user_email;

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
	private Double userScore;
	@Column(nullable = true)
	private Integer totalCount;
	@Column(nullable = true)
	private String uRankImg1;
	private String uRankImg2;
	private String uRankImg3;
	private String uRankImg4;
	private String uRankImg5;

	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date regDate;
	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date logDate;
	private String approvalStatus;
	private String approvalKey;

	@Column(name = "user_time")
	private Integer userTime;

	// 세션 테스트용 임시컬럼
	private String role;

	@OneToMany(mappedBy = "uservo", cascade = CascadeType.ALL)
	private List<ReviewRegistrationvo> reviewRegistrationList = new ArrayList<ReviewRegistrationvo>();


	@OneToMany(mappedBy = "uservo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Commentvo> commentList = new ArrayList<Commentvo>();


}
