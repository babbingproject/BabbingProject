package com.example.demo.service.user;

import javax.servlet.http.HttpServletRequest;

public interface PwSearchService {
	public void mailSendWithPassword(String user_email, String nickname, HttpServletRequest request);

	public int searchPassword(String user_email, String password);
}
