package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.rank.RankService;

@Controller
public class RankController {
	@Autowired
	RankService rankService;
}
