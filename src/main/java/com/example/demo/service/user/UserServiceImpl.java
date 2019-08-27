package com.example.demo.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.mypage.UserVO;

@Service
public class UserServiceImpl implements UserService   {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserVO getUser(UserVO user) {
		return null;
	}
	
	//유저를 리스트로 담아서 뿌려주는 임플 메소드
	@Override
	public List<UserVO> getUservoList(UserVO uservo){
		return (List<UserVO>) userRepo.findAll();
	}
	
	//유저 정보를 높은 펄로우 수 순서대로 리스트 형식에 6명 저장해주는 메소드
	@Override
	public List<Object[]> getUservoListOrderByFollowingCountDes(){
		return userRepo.getFindAllByIdOrderbyFollowingCountDESC();
	}
	
	//유저 닉네임으로 검색하기
	@Override
	public List<Object[]> getSearchKeyword(String searchKeyword){
		return userRepo.getSearchKeyword(searchKeyword);
	}
	@Override
	public List<UserVO> getUservoListOrderByFollowingCountDes(UserVO uservo){
		return userRepo.findAllByIdOrderbyFollowingCountDESC(uservo);

	}
	
	
}
