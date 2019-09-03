package com.example.demo.service.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.mypage.Uservo;

public interface UserRepository extends CrudRepository<Uservo, Integer>{
	

	@Query(value = "SELECT u.user_id, u.nickname, u.profile_img, u.following_count, u.post_count FROM Uservo u ORDER BY u.following_count DESC limit 10", nativeQuery = true)
	List<Object[]> getFindAllByIdOrderbyFollowingCountDESC();
	
	//유저 서치
	@Query(nativeQuery = true, value=""
			+ "SELECT user_id, nickname, profile_img, following_count, post_count "
			+ "FROM Uservo WHERE nickname LIKE %?1% "
			+ "ORDER BY following_count DESC "
			+ "LIMIT 6")
	List<Object[]> getSearchKeyword(String searchKeyword);

	@Query(nativeQuery = true, value = "SELECT * FROM Uservo ORDER BY following_count DESC LIMIT 6")
<<<<<<< HEAD
	List<Uservo> findAllByIdOrderbyFollowingCountDESC(Uservo Uservo);


=======
	List<Uservo> findAllByIdOrderbyFollowingCountDESC(Uservo uservo);
>>>>>>> 진광
}

