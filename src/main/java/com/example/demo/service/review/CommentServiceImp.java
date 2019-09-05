package com.example.demo.service.review;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.QCommentvo;
import com.example.demo.domain.review.QReviewRegistrationvo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class CommentServiceImp implements CommentService {
	private static final Logger logger = LoggerFactory.getLogger(CommentServiceImp.class);
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Commentvo> selectCommentListAllById(int reviewId) {
		
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		QReviewRegistrationvo qReviewRegistrationvo = QReviewRegistrationvo.reviewRegistrationvo;
		QCommentvo qCommentvo = QCommentvo.commentvo;
		
		return query.selectFrom(qCommentvo)
				.where(qCommentvo.reviewRegistrationvo.reviewId.eq(qReviewRegistrationvo.reviewId))
				.orderBy(qCommentvo.commentId.desc()).fetch();
		
	}

	@Override
	public void insertComment(Commentvo commentvo) {
				
		commentRepo.save(commentvo);
		
	}

	

	
}
