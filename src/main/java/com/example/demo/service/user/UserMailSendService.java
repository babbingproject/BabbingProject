package com.example.demo.service.user;

import javax.servlet.http.HttpServletRequest;

public interface UserMailSendService {

	public void mailSendWithUserKey(String user_email, String nickname, HttpServletRequest request);

	public int alter_userKey_service(String user_email, String key);

	
	



}
