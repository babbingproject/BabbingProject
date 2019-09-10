package com.example.demo.service.advertisement;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.mypage.Advertisementvo;

public interface AdvertisementRepository extends JpaRepository<Advertisementvo, Integer>{
	
	//기업 정보 가지고와서 리스트에 저장하기

<<<<<<< HEAD
	@Query(nativeQuery=true, value = "SELECT advertisement_id, advertisement_name, profile_img, puted_count FROM advertisementvo ORDER BY advertisement_id  DESC limit 6")
	List<Object[]> findAllbyAdvertisementidOrderByWeightedAvg();
=======
	@Query(nativeQuery=true, value = "SELECT advertisement_id, advertisement_name, profile_img, puted_count, evaluation_avg FROM advertisementvo ORDER BY evaluation_avg  DESC limit 6")

	List<Object[]> findAllbyAdvertisementidOrderbyEvaluationAvg();
>>>>>>> a8d3f6a02c346d9c06edc4852d1451541ca1283b
	
	//기업 정보 서치
	@Query(nativeQuery=true, value = ""
			+ "SELECT advertisement_id, advertisement_name, profile_img, puted_count "
			+ "FROM advertisementvo WHERE advertisement_name LIKE %:searchKeyword% "
			+ "LIMIT 6")
	Page<Advertisementvo> getSearchKeyword(String searchKeyword, Pageable pageable);
	
	List<Advertisementvo> findByAdvertisementname(String advertisementName);
	
	@Query(nativeQuery=true, value=""
			+ "UPDATE advertisementvo "
			+ "SET puted_count = puted_count + 1 "
			+ "WHERE advertisement_name = ?1 ")
	void increasePut(String followerYou);
	
	@Query(nativeQuery=true, value=""
			+ "UPDATE advertisementvo "
			+ "SET puted_count = puted_count - 1 "
			+ "WHERE advertisement_name = ?1 ")
	void decreasePut(String followerYou);
	List<Object[]> getSearchKeyword(String searchKeyword);
	
	@Query("SELECT advertisementname FROM Advertisementvo ad WHERE ad.advertisement_email like %?1%")
	String selectAdvertisementname(String adEmail);
	@Query("SELECT advertisement_num FROM Advertisementvo ad WHERE ad.advertisementname like %?1%")
	String selectAdvertisementNum(String nickName);
}
