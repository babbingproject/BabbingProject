package com.example.demo.service.review;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.mypage.QUservo;
import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.QReviewRegistrationvo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.user.UserRepository;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepo;

	@Autowired
	UserRepository userRepo;

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Uservo> selectUservoInfo() {

		JPAQueryFactory query = new JPAQueryFactory(em);

		QUservo user = QUservo.uservo;

		return query.selectFrom(user).orderBy(user.userId.desc()).fetch();
	}

	@Override
	public List<Object[]> getKoreanTopSix() {
		return reviewRepo.getKoreanFoodTopSix();
	}

	@Override
	public List<Object[]> getNewestReview() {
		return reviewRepo.getNewestReview();
	}

	@Override
	public List<Object[]> getEverythingTopSix() {
		return reviewRepo.getEverything();
	}

	@Override
	public List<Object[]> getBusinessFieldOne() {
		return reviewRepo.getBusinessFieldOne();
	}

	@Override
	public List<Object[]> getBusinessFieldTwo() {
		return reviewRepo.getBusinessFieldTwo();
	}

	@Override
	public List<Object[]> getBusinessFieldThree() {
		return reviewRepo.getBusinessFieldThree();
	}

	@Override
	public List<Object[]> getBusinessFieldFour() {
		return reviewRepo.getBusinessFieldFour();
	}

	@Override
	public List<Object[]> getBusinessFieldFive() {
		return reviewRepo.getBusinessFieldFive();
	}

	@Override
	public List<Object[]> getBusinessFieldSix() {
		return reviewRepo.getBusinessFieldSix();
	}

	@Override
	public List<Object[]> getBusinessFieldSeven() {
		return reviewRepo.getBusinessFieldSeven();
	}

	@Override
	public List<Object[]> getSearchKeyword(String searchKeyword) {
		return reviewRepo.getSearchKeyword(searchKeyword);
	}

	@Override
	public void insertReview(ReviewRegistrationvo reviewRegistrationvo, Uservo Uservo) {
		userRepo.save(Uservo);
		reviewRepo.save(reviewRegistrationvo);
	}

	@Override
	public List<ReviewRegistrationvo> selectReviewList() {

		JPAQueryFactory query = new JPAQueryFactory(em);

		QReviewRegistrationvo reviewRegistrationvo = QReviewRegistrationvo.reviewRegistrationvo;

		return query.selectFrom(reviewRegistrationvo).orderBy(reviewRegistrationvo.reviewId.desc()).fetch();

	}

	@Override
	public List<ReviewRegistrationvo> selectReviewList(ReviewRegistrationvo reviewRegistrationvo) {

		JPAQueryFactory query = new JPAQueryFactory(em);

		QReviewRegistrationvo qReviewRegistrationvo = QReviewRegistrationvo.reviewRegistrationvo;

		return query.selectFrom(qReviewRegistrationvo).orderBy(qReviewRegistrationvo.reviewId.desc()).fetch();

	}
//	@Override
//	public Tuple selectReviewIdJoinUserId(Uservo Uservo, ReviewRegistrationvo reviewRegistrationvo) {
//		JPAQueryFactory query = new JPAQueryFactory(em);
//		
//		QUservo qUservo = QUservo.uservo;
//		QReviewRegistrationvo qreviewRegistrationvo = QReviewRegistrationvo.reviewRegistrationvo;
//		
//		return query.select(qreviewRegistrationvo,qUservo.nickname).from(qreviewRegistrationvo)
//				.innerJoin(qUservo).on(qUservo.userId.eq(qreviewRegistrationvo.uservo)).fetchOne();
//		
//	}

}
