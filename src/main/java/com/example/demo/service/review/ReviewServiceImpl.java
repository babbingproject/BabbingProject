package com.example.demo.service.review;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Service;

import com.example.demo.domain.mypage.QUservo;
import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.QReviewRegistrationvo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.user.UserRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
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
	public void insertReview(ReviewRegistrationvo reviewRegistrationvo, Uservo uservo) {
		userRepo.save(uservo);
		reviewRepo.save(reviewRegistrationvo);
	}

	@Override
	public List<ReviewRegistrationvo> selectReviewList() {
		
		JPAQueryFactory query = new JPAQueryFactory(em);

		QReviewRegistrationvo reviewRegistrationvo = QReviewRegistrationvo.reviewRegistrationvo;

		return query.selectFrom(reviewRegistrationvo).orderBy(reviewRegistrationvo.reviewId.desc()).fetch();
		
	}
	@Override
	public Tuple selectReviewIdJoinUserId(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo) {
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		QUservo qUservo = QUservo.uservo;
		QReviewRegistrationvo qreviewRegistrationvo = QReviewRegistrationvo.reviewRegistrationvo;
		
		return query.select(qreviewRegistrationvo,qUservo.nickname).from(qreviewRegistrationvo)
				.innerJoin(qUservo).on(qUservo.userId.eq(qreviewRegistrationvo.userId)).fetchOne();
		
	}



}
