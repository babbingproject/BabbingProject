package com.example.demo.controller;

import org.springframework.social.facebook.api.User;

import com.example.demo.domain.mypage.Uservo;

public interface signInUserDetailsService {

	static void onAuthenticationBinding(Uservo uservo, User userProfile) {
		// TODO Auto-generated method stub
		
	}

}
