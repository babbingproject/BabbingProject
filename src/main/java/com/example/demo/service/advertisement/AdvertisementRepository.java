package com.example.demo.service.advertisement;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.mypage.Advertisementvo;

public interface AdvertisementRepository extends JpaRepository<Advertisementvo, Integer>{
	
	//기업 정보 가지고와서 리스트에 저장하기

	@Query(nativeQuery=true, value = "SELECT advertisement_id, advertisement_name, profile_img, puted_count FROM advertisementvo ORDER BY advertisement_id  DESC limit 6")

	List<Object[]> findAllbyAdvertisementidOrderByWeightedAvg();
	
	//기업 정보 서치
	@Query(nativeQuery=true, value = ""
			+ "SELECT advertisement_id, advertisement_name, profile_img, puted_count "
			+ "FROM advertisementvo WHERE advertisement_name LIKE %:searchKeyword% "
			+ "LIMIT 6")
	List<Object[]> getSearchKeyword(String searchKeyword);
}
