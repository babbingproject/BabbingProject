package com.example.demo.service.user;

import javax.servlet.http.HttpServletRequest;

public interface UserMailSendService {

	public void mailSendWithUserKey(String userEmail, String nickname, HttpServletRequest request);

	public int alter_userKey_service(String userEmail, String key);

	
	



}
