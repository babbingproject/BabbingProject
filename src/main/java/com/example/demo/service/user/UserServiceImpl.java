package com.example.demo.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.mypage.Uservo;

@Service
public class UserServiceImpl implements UserService   {

	@Autowired
	private UserRepository userRepo;

	@Override
	public Uservo getUser(Uservo user) {
		return null;
	}
	
	//유저를 리스트로 담아서 뿌려주는 임플 메소드
	@Override
	public List<Uservo> getUservoList(Uservo uservo){
		return (List<Uservo>) userRepo.findAll();
	}
	
	//유저 정보를 높은 펄로우 수 순서대로 리스트 형식에 6명 저장해주는 메소드
	@Override
	public List<Uservo> getUservoListOrderByFollowingCountDes(Uservo uservo){
		return userRepo.findAllByIdOrderbyFollowingCountDESC(uservo);
	}
	
	
}
