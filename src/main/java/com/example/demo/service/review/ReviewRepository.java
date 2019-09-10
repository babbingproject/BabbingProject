package com.example.demo.service.review;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.review.ReviewRegistrationvo;

public interface ReviewRepository extends JpaRepository<ReviewRegistrationvo, Integer>{
	
	@Query(nativeQuery=true, value="SELECT review_id, review_place, title, business_field_id FROM review_registrationvo where business_field_id ='1' ORDER BY write_date DESC LIMIT 6")
	List<Object[]> getKoreanFoodTopSix();
	
//	@Query(nativeQuery=true, value=""
//			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img " + 
//			"FROM review_registrationvo AS r, review_imagevo AS ri, uservo AS user " + 
//			"where r.review_id = ri.review_id AND r.user_id = user.user_id" + 
//			"ORDER BY r.write_date DESC LIMIT 6")
	@Query(nativeQuery=true, value=""
			+ "SELECT * , ri.img, user.profile_img, user.nickname "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "GROUP BY ri.review_id "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	Iterable<ReviewRegistrationvo> getEverything();
	
	@Query(nativeQuery=true, value="SELECT * , ri.img, user.profile_img, user.nickname "
			+ "FROM review_registrationvo AS r INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "GROUP BY ri.review_id "
			+ "ORDER BY r.write_date DESC LIMIT 3")
//			+ "ORDER BY r.write_date DESC LIMIT 3")
	Iterable<ReviewRegistrationvo> getNewestReview();
	
	@Query(nativeQuery=true, value="SELECT * "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "ORDER BY r.write_date DESC LIMIT 3")
	List<ReviewRegistrationvo> getNewestReviewList();
	
	
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img, user.nickname "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "AND r.business_field_id = 'kor'"
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldKor();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img, user.nickname  "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "AND r.business_field_id = 'wes' "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldWes();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img, user.nickname  "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "AND r.business_field_id = 'jpn' "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldJpn();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img, user.nickname  "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "AND r.business_field_id = 'chn' "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldChn();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img, user.nickname  "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "AND r.business_field_id = 'snk'"
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldSnk();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img, user.nickname  "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "AND r.business_field_id = 'fst' "
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldFst();
	
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img, user.nickname  "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "AND r.business_field_id = 'caf'"
			+ "ORDER BY r.write_date DESC LIMIT 6")
	List<Object[]> getBusinessFieldCaf();
	
	//리뷰 서치
	@Query(nativeQuery=true, value=""
			+ "SELECT r.review_id, r.review_place, r.title, r.business_field_id, ri.img, user.profile_img, user.nickname  "
			+ "FROM review_registrationvo AS r INNER JOIN review_imagevo AS ri "
			+ "ON r.review_id = ri.review_id "
			+ "INNER JOIN uservo AS user "
			+ "ON r.user_id = user.user_id "
			+ "AND r.title LIKE %:searchKeyword% "
			+ "LIMIT 8")
//			+ "ORDER BY r.write_date DESC LIMIT 8 ")
//	@Query("select r.reviewId, r.reviewPlace, r.title, r.businessFieldId, ri.img "
//			+ "from ReviewRegistrationvo r, ReviewImagevo ri "
//			+ "WHERE r.reviewId = ri.reviewRegistrationvo.reviewId and r.title LIKE ?1")
	List<Object[]> getSearchKeyword(String searchKeyword);
//	Page<Object[]> getSearchKeyword(String searchKeyword, PageRequest pageRequest);
	
}
