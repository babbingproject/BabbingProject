package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService  {
	@Autowired
	LoginRepository memberRepo;
}
