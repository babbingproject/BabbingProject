package com.example.demo.domain.campaign;

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
public class Participantsvo {
	@Id
	@GeneratedValue
	private int participants_id;
	private int campaign_id;
	private int user_id;
}
