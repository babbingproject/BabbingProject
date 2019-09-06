package com.example.demo.domain.campaign;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.domain.mypage.Uservo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Participantsvo {
	@Id
	@GeneratedValue
	private int participantsId;
	
	@ManyToOne
	@JoinColumn(name="campaignId")
	private Campaignvo campaignvo;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Uservo uservo;
	
	@Column(nullable=false, columnDefinition = "char default 'N'")
	private char participation;
}
