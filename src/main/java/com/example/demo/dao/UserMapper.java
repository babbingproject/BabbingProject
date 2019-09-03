package com.example.demo.dao;

<<<<<<< HEAD
=======

>>>>>>> 진광
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.mypage.Uservo;

@Mapper
public interface UserMapper {
	public int joinUser (Uservo userVO); // 회원가입 입니다.

	public int emailCheck(@Param("userEmail") String userEmail);// 이메일 중복 확인 입니다.
	//@Param("userEmail") 생략해도 돕니다.
	public int nickCheck(String nickname);// 닉네임 중복 확인 입니다.
	
	
	/* 아직 미구현 */
	public int GetKey(String userEmail, String userKey); // 유저 인증키 생성 메서드
	public int alter_userKey(String userEmail, String key); // 유저 인증키 Y로 바꿔주는 메서드
	public int searchPassword(String userEmail, String nickname, String key); // 회원 임시 비밀번호 변경 메서드
	public Uservo loginUser(@Param("userEmail")String userEmail, @Param("user_pw")String user_pw);// 유저 로그인 메서드


	
	
}
