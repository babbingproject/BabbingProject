package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.UserRepository;
import com.example.demo.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserVO getUser(UserVO user) {
		return null;
	}
	
	
}
