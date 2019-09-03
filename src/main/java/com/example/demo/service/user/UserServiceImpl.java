package com.example.demo.service.user;

import java.util.List;
import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import com.example.demo.dao.UserMapper;
>>>>>>> 진광
import com.example.demo.domain.mypage.Uservo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SqlSessionTemplate userSqlSessin;
	@Autowired
	private UserMapper userMapper;

	@Override
	public Uservo getUser(Uservo user) {
		return null;
	}

	// 유저를 리스트로 담아서 뿌려주는 임플 메소드
	@Override
	public List<Uservo> getUservoList(Uservo Uservo) {
		return (List<Uservo>) userRepo.findAll();
	}

	// 유저 정보를 높은 펄로우 수 순서대로 리스트 형식에 6명 저장해주는 메소드
	@Override
<<<<<<< HEAD
	public List<Uservo> getUservoList(Uservo Uservo){
		return (List<Uservo>) userRepo.findAll();
=======
	public List<Uservo> getUservoListOrderByFollowingCountDes(Uservo Uservo) {
		return userRepo.findAllByIdOrderbyFollowingCountDESC(Uservo);
>>>>>>> 진광
	}

	@Override
<<<<<<< HEAD
	public List<Object[]> getUservoListOrderByFollowingCountDes(){
		return userRepo.getFindAllByIdOrderbyFollowingCountDESC();
	}
	
	//유저 닉네임으로 검색하기
	@Override
	public List<Object[]> getSearchKeyword(String searchKeyword){
		return userRepo.getSearchKeyword(searchKeyword);
	}
	@Override
	public List<Uservo> getUservoListOrderByFollowingCountDes(Uservo Uservo){
		return userRepo.findAllByIdOrderbyFollowingCountDESC(Uservo);

	}

	@Override
	public Optional<Uservo> insertUserId(Uservo user) {
		
		return userRepo.findById(new Uservo().getUserId());
=======
	public int joinUser(Uservo Uservo) {
		// TODO Auto-generated method stub
		return userMapper.joinUser(Uservo);
>>>>>>> 진광
	}

	@Override
	public int emailCheck(Uservo vo, String userEmail) {
		// TODO Auto-generated method stub
		userMapper = userSqlSessin.getMapper(UserMapper.class);// 아직 왜 인지 모름

		return userMapper.emailCheck(vo.getUserEmail());
	}

	@Override
	public int nickCheck(Uservo vo,String nickname) {
		// TODO Auto-generated method stub
		return  userMapper.nickCheck(vo.getNickname());
	}

}
