package com.example.demo.domain.review;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.domain.mypage.Uservo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"uservo","reviewRegistrationvo"})
@Entity
public class Commentvo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private String contents;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date writeDate;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@ManyToOne
	@JoinColumn(name = "reviewId", nullable = false)
	private ReviewRegistrationvo reviewRegistrationvo;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private Uservo uservo;

	public void getReviewRegistrationvo(ReviewRegistrationvo reviewRegistrationvo) {
		this.reviewRegistrationvo = reviewRegistrationvo;
		reviewRegistrationvo.getCommentList().add(this);
	}


	public void setUservo(Uservo uservo) {
		this.uservo = uservo;
		uservo.getCommentList().add(this);
	}

}
