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
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 1 "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldOne();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 2 "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldTwo();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 3 "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldThree();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 4 "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldFour();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 5 "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldFive();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 6 "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldSix();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.business_field_id = 7 "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldSeven();
	
	//리뷰 서치
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img "
			+ "FROM review_registrationvo AS r, review_imagevo AS ri "
			+ "WHERE r.review_id = ri.review_id AND r.title LIKE %?1% "
			+ "ORDER BY r.write_date DESC LIMIT 8")
	List<Object[]> getSearchKeyword(@Param("searchKeyword")String searchKeyword);
	
}
