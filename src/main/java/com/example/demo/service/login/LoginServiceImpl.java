package com.example.demo.service.login;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.mypage.Uservo;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepository memberRepo;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SqlSessionTemplate userSqlSession;

	@Override
	public int userLogin_service(Uservo Uservo, String user_check, HttpSession session) {
		// TODO Auto-generated method stub
		String user_eamil = Uservo.getUser_email();
		String user_pw = Uservo.getPassword();

		userMapper = userSqlSession.getMapper(UserMapper.class);
		Uservo vo = userMapper.loginUser(user_eamil, user_pw); // 비번도 체크

		System.out.println("UserLoginService // 로그인 객체 확인 vo : " + vo);

		// 로그인 결과값
		int result = 0;

		// 회원 정보가 없을 시
		if (vo == null) {
			return 0;
		}

		// 인증 안 했을 경우 인증하란 메세지 발생
		return (vo.getUser_key().equalsIgnoreCase("y")) ? 1 : -2;

	}

}
