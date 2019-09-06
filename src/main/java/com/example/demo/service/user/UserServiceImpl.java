package com.example.demo.service.user;

import java.util.List;
import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
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
	public Uservo getUser(Uservo uservo) {
		
		/*
		 * JPAQueryFactory query = new JPAQueryFactory(em);
		 * 
		 * QUservo qUservo = QUservo.uservo;
		 * 
		 * String findByNickName = userRepo.findById(uservo.getNickname()).get();
		 * qUservo = query.selectFrom(qUservo)
		 * .where(qUservo.nickname.eq(uservo)).fetchOne();
		 */

		Optional<Uservo> findNickName = userRepo.findByNickName(uservo.getNickname());
		if (findNickName.isPresent()) 
			return findNickName.get();
		else return null;
			
	}

	// 유저를 리스트로 담아서 뿌려주는 임플 메소드
	@Override
	public List<Uservo> getUservoList(Uservo Uservo) {
		return (List<Uservo>) userRepo.findAll();
	}

	// 유저 정보를 높은 펄로우 수 순서대로 리스트 형식에 6명 저장해주는 메소드
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

	public List<Uservo> getUservoListOrderByFollowingCountDes(Uservo uservo){
		return userRepo.findAllByIdOrderbyFollowingCountDESC(uservo);


	}
	// test용 메서드
	@Override
	public Optional<Uservo> insertUserId(Uservo user) {
		
		return userRepo.findById(new Uservo().getUserId());
	}

	public int joinUser(Uservo Uservo) {
		// TODO Auto-generated method stub
		return userMapper.joinUser(Uservo);
	}

	@Override
	public int emailCheck(Uservo vo, String user_email) {
		// TODO Auto-generated method stub
		userMapper = userSqlSessin.getMapper(UserMapper.class);// 아직 왜 인지 모름

		return userMapper.emailCheck(vo.getUser_email());
	}

	@Override
	public int nickCheck(Uservo vo,String nickname) {
		// TODO Auto-generated method stub
		return  userMapper.nickCheck(vo.getNickname());
	}

}
