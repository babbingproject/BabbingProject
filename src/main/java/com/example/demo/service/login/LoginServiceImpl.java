package com.example.demo.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService  {
	@Autowired
	LoginRepository memberRepo;
}
