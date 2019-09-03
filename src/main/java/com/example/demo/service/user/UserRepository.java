package com.example.demo.service.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.mypage.Uservo;

public interface UserRepository extends CrudRepository<Uservo, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM Uservo ORDER BY following_count DESC LIMIT 6")
	List<Uservo> findAllByIdOrderbyFollowingCountDESC(Uservo uservo);
}
