package com.example.demo.service.user;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.mypage.Uservo;

@Service
public class UserServiceImpl implements UserService   {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;
	
	/*
	 * @Autowired private EntityManager em;
	 */
	// 세션 테스트용 로그인 메소드
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
//		logger.info(uservo.toString());
		Optional<Uservo> findNickName = userRepo.findByNickName(uservo.getNickname());
		if (findNickName.isPresent()) 
			return findNickName.get();
		else return null;
			
	}
	
	//유저를 리스트로 담아서 뿌려주는 임플 메소드
	@Override

	public List<Uservo> getUservoList(Uservo uservo){

		return (List<Uservo>) userRepo.findAll();
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

	public List<Uservo> getUservoListOrderByFollowingCountDes(Uservo uservo){
		return userRepo.findAllByIdOrderbyFollowingCountDESC(uservo);


	}
	// test용 메서드
	@Override
	public Optional<Uservo> insertUserId(Uservo user) {
		
		return userRepo.findById(new Uservo().getUserId());
	}
	
}
