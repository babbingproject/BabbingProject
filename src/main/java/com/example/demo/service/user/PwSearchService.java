package com.example.demo.service.user;

import javax.servlet.http.HttpServletRequest;

public interface PwSearchService {
	public void mailSendWithPassword(String userEmail, String nickname, HttpServletRequest request);

	public int searchPassword(String userEmail, String password);
}
