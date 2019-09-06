package com.example.demo.domain.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Commentvo2 {
	private int commentId;
	private String contents;
	private int reviewId;
	private int userId;

}
