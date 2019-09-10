package com.example.demo.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.mypage.Uservo;

public interface UserRepository extends CrudRepository<Uservo, Integer>{
	

	@Query(value = "SELECT u.user_id, u.nickname, u.profile_img, u.following_count, u.post_count FROM Uservo u ORDER BY u.user_score DESC limit 10", nativeQuery = true)
	List<Object[]> getAllOrderbyUserscoreDESC();
	
	List<Uservo> findByNickname(String nickname);
	//유저 서치
	@Query(nativeQuery = true, value=""
			+ "SELECT user_id, nickname, profile_img, following_count, post_count "
			+ "FROM Uservo WHERE nickname LIKE %?1% "
			+ "ORDER BY following_count DESC "
			+ "LIMIT 6")
	List<Object[]> getSearchKeyword(String searchKeyword);

	@Query(nativeQuery = true, value = "SELECT * FROM Uservo ORDER BY following_count DESC LIMIT 6")
	List<Uservo> findAllByIdOrderbyFollowingCountDESC(Uservo uservo);
	
	@Query(value = "select U from Uservo U where U.nickname like %?1%" )
	Optional<Uservo> findByNickName(String nickName);
	
	@Query(nativeQuery=true, value=""
			+ "UPDATE uservo "
			+ "SET favor_factor = favor_factor + 1 "
			+ "WHERE nickname = ?1")
	void likeFavorFactor(String nickname);
	
	@Query(nativeQuery=true, value=""
			+ "UPDATE uservo "
			+ "SET favor_factor = favor_factor -1 "
			+ "WHERE nickname = ?1")
	void unlikeFavorFactor(String nickname);
	
	@Query(nativeQuery=true, value=""
			+ "UPDATE uservo "
			+ "SET following_count = following_count +1 "
			+ "WHERE nickname = ?1")
	void followingCountIncrease(String nickname);
	
	@Query(nativeQuery=true, value=""
			+ "UPDATE uservo "
			+ "SET following_count = following_count -1 "
			+ "WHERE nickname = ?1")
	void followingCountDecrease(String nickname);
	
	@Query(nativeQuery=true, value=""
			+ "UPDATE uservo "
			+ "SET scrap_factor = scrap_factor + 1 "
			+ "WHERE user_id = ?1")
	void scrapFactorIncrease(Integer reviewUserId);
	
	@Query(nativeQuery=true, value=""
			+ "UPDATE uservo "
			+ "SET scrap_factor = scrap_factor - 1 "
			+ "WHERE user_id = ?1")
	void scrapFactorDecrease(Integer reviewUserId);
}

