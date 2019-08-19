package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String goIndex() {
		return "/main/home";
	}
	
	@RequestMapping("/board")
	public String goBoard() {
		return "board";
	}
}
