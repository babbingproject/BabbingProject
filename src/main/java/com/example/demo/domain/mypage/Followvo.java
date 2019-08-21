package com.example.demo.domain.mypage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Followvo {
	@Id @GeneratedValue
	private int follow_id;
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date following_time;
	private int followingUser_id;
	private int followerUser_id;
}
