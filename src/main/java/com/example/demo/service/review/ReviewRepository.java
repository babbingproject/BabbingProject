package com.example.demo.service.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.review.ReviewRegistrationvo;

public interface ReviewRepository extends JpaRepository<ReviewRegistrationvo, Integer>{
	
	@Query(nativeQuery=true, value="SELECT review_id, review_place, title, business_field_id FROM review_registrationvo where business_field_id ='1' ORDER BY write_date DESC LIMIT 6")
	List<Object[]> getKoreanFoodTopSix();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img " + 
			"FROM review_registrationvo AS r, review_imagevo AS ri " + 
			"where r.review_id = ri.review_id " + 
			"ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getEverything();
	
	@Query(nativeQuery=true, value="SELECT r.review_id, r.review_place, r.title, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id "
			+ "ORDER BY r.write_date DESC LIMIT 4")
	List<Object[]> getNewestReview();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 'kor'"
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldKor();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 'wes' "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldWes();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 'jpn' "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldJpn();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 'chn' "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldChn();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 'snk'"
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldSnk();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 'fst' "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldFst();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 'caf'"
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldCaf();
	
	//리뷰 서치
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.title LIKE %:searchKeyword% "
			+ "ORDER BY r.write_date DESC LIMIT 8")
	List<Object[]> getSearchKeyword(String searchKeyword);
	
}
