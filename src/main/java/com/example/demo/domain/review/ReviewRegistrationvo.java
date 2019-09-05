package com.example.demo.domain.review;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.domain.mypage.Uservo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"commentList", "uservo"})
@Entity
public class ReviewRegistrationvo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int reviewId;
	private String reviewPlace;
	private String title;
	private String advantages;
	private String disadvantages;

//	@ManyToOne
//	@JoinColumn(name="user_id", nullable=false)
//	private Uservo uservo;

//	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date writeDate;
	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date modifiedDate;
	@Column(nullable = true) // 임시
	private Integer reviewTypeId;
	@Column(nullable = true) // 임시
	private Integer businessFieldId;
	@Column(nullable = true) // 임시
	private Integer themeId;
	
	
	private String writer; // 게시판 테스트용 임시 칼럼
	private Long cnt;	// 게시판 테스트용 임시 칼럼

	/*
	 * @OneToMany(mappedBy = "reviewId", fetch = FetchType.EAGER, cascade =
	 * CascadeType.ALL) private List<ReviewImagevo> reviewImagevoList = new
	 * ArrayList<ReviewImagevo>();
	 */
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private Uservo uservo;

	@OneToMany(mappedBy = "reviewRegistrationvo", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST} )
	private List<Commentvo> commentList = new ArrayList<Commentvo>();

	@OneToMany(mappedBy = "reviewRegistrationvo", cascade = CascadeType.ALL)
	private List<ReviewImagevo> reviewImgList = new ArrayList<ReviewImagevo>();

	public void setUservo(Uservo uservo) {
		this.uservo = uservo;
		uservo.getReviewRegistrationList().add(this);

	}

}
