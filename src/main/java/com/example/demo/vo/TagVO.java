package com.example.demo.vo;

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
public class TagVO {

	@Id @GeneratedValue
	private int tag_id;
	private String tag_name;
	private String tag_content;
	private int tag_x;
	private int tag_y;
	private int img_id;
}
