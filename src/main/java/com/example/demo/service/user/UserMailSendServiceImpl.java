package com.example.demo.service.user;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.mypage.Uservo;

@Service
public class UserMailSendServiceImpl implements UserMailSendService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private UserMapper userMapper;

	// 이메일 난수 만드는 메서드
	private String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}

	// 난수를 이용한 키 생성
	private boolean lowerCheck;
	private int size;

	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}

	// 회원가입 발송 이메일(인증키 발송)

	@Override
	public void mailSendWithUserKey(String user_email, String nickname, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String key = getKey(false, 20);
		userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.GetKey(user_email, key);
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>안녕하세요 밥빙 입니다!</h2><br><br>" + "<h3>" + user_email + "님</h3>"
				+ "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " + "<a href='http://localhost:80" + request.getContextPath()
				+ "/user/key_alter?user_email=" + user_email + "&userKey=" + key + "'>인증하기</a></p>"
				+ "(혹시 본인이 요청하시지 않은 인증메일 이라면 개인정보 유출 여부를 확인하세요!)";
		try {
			mail.setSubject("[본인인증]안녕하세요! 밥빙 인증메일입니다", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(user_email));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int alter_userKey_service(String user_email, String key) {
		int resultCnt = 0;

		userMapper = sqlSession.getMapper(UserMapper.class);
		resultCnt = userMapper.alter_user_key(user_email, key);

		return resultCnt;

	}

	

}
