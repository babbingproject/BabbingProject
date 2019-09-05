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

@Service
public class PwSearchServiceImpl implements PwSearchService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private UserMapper userMapper;

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

	//임시 비밀번호 이메일 발송
	@Override
	public void mailSendWithPassword(String userEmail, String nickname, HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 비밀번호는 8자리로 보내고 데이터베이스 비밀번호를 바꿔준다
		String password = getKey(false, 10);
		userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.searchPassword(userEmail, password);
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>안녕하세요 '" + userEmail + "' 님</h2><br><br>" + "<p>비밀번호 찾기를 신청해주셔서 임시 비밀번호를 발급해드렸습니다.</p>"
				+ "<p>임시로 발급 드린 비밀번호는 <h2 style='color : blue'>'" + password
				+ "'</h2>이며 로그인 후 마이페이지에서 비밀번호를 변경해주시거나 하단의</p><br>"
				+"<p>비밀번호 변경하기 버튼을 누르시면 바로 변경 페이지로 이동합니다! : " + "<h3><a href=http://localhost:80"+request.getContextPath()
				+ "/userpw/key_alter?userEmail=" + userEmail + "&password=" + password + "'> 즉시 비밀번호 변경하기</a></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
		try {
			mail.setSubject("[비밀번호 재발급] 임시 비밀번호가 발급되었습니다", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(userEmail));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// 비밀번호 암호화해주는 메서드
		password = UserSha256.encrypt(password);
		// 데이터 베이스 값은 암호한 값으로 저장시킨다.
		userMapper.searchPassword(userEmail, password);
		System.out.println("메일전송 완료 비번");

	}

	@Override
	public int searchPassword(String userEmail, String password) {
		// TODO Auto-generated method stub
		int resultCnt = 0;

		userMapper = sqlSession.getMapper(UserMapper.class);
		resultCnt = userMapper.searchPassword(userEmail, password);

		return resultCnt;
	}


}
