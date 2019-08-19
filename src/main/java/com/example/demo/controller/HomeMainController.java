package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeMainController {

	@RequestMapping("/")
	public String goIndex() {
		return "/main/homemain";
	}
	
	@RequestMapping("/board")
	public String goBoard() {
		return "board";
	}
}
