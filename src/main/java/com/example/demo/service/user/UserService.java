package com.example.demo.service.user;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.mypage.UserVO;

public interface UserService {

	UserVO getUser(UserVO user);
	
	Optional<UserVO> insertUserId(UserVO user);

	//유저를 리스트로 담아서 뿌려주는 임플 메소드
	List<UserVO> getUservoList(UserVO uservo);

	//유저 정보를 높은 펄로우 수 순서대로 리스트 형식에 6명 저장해주는 메소드

	List<Object[]> getUservoListOrderByFollowingCountDes();

	//유저 닉네임으로 검색하기
	List<Object[]> getSearchKeyword(String searchKeyword);

	List<UserVO> getUservoListOrderByFollowingCountDes(UserVO uservo);


}