package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository memberRepo;
}
