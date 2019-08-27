package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.mypage.UserVO;

@Mapper
public interface UserMapper {
	public int joinUser (UserVO userVO); // 회원가입 입니다.

	public int emailCheck(@Param("user_email") String user_email);// 이메일 중복 확인 입니다.
	//@Param("user_email") 생략해도 돕니다.
	public int nickCheck(String nickname);// 닉네임 중복 확인 입니다.
	//public List<UserVO> emailCheck2(@Param("user_email") String user_email);
	
	
}
