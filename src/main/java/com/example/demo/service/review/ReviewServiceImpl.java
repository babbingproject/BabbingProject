package com.example.demo.service.review;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.QReviewRegistrationvo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.user.UserRepository;
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
	public List<Object[]> getKoreanTopSix() {
		return reviewRepo.getKoreanFoodTopSix();
	}

//	@Override
//	public List<Object[]> getNewestReview() {
//		return reviewRepo.getNewestReview();
//	}

	@Override
	public List<ReviewRegistrationvo> getEverythingTopSix() {
		return (List<ReviewRegistrationvo>) reviewRepo.getEverything();
	}

	@Override
	public List<ReviewRegistrationvo> getBusinessFieldOne() {
		return (List<ReviewRegistrationvo>) reviewRepo.getBusinessFieldKor();
	}

	@Override
	public List<ReviewRegistrationvo> getBusinessFieldTwo() {
		return (List<ReviewRegistrationvo>) reviewRepo.getBusinessFieldWes();
	}

	@Override
	public List<ReviewRegistrationvo> getBusinessFieldThree() {
		return (List<ReviewRegistrationvo>) reviewRepo.getBusinessFieldJpn();
	}

	@Override
	public List<ReviewRegistrationvo> getBusinessFieldFour() {
		return (List<ReviewRegistrationvo>) reviewRepo.getBusinessFieldChn();
	}

	@Override
	public List<ReviewRegistrationvo> getBusinessFieldFive() {
		return (List<ReviewRegistrationvo>) reviewRepo.getBusinessFieldSnk();
	}

	@Override
	public List<ReviewRegistrationvo> getBusinessFieldSix() {
		return (List<ReviewRegistrationvo>) reviewRepo.getBusinessFieldFst();
	}

	@Override
	public List<ReviewRegistrationvo> getBusinessFieldSeven() {
		return (List<ReviewRegistrationvo>) reviewRepo.getBusinessFieldCaf();
	}

	@Override
	public List<Object[]> getSearchKeyword(String searchKeyword) {
		return reviewRepo.getSearchKeyword(searchKeyword);
	}
//	@Override
//	public Page<Object[]> getSearchKeyword(String searchKeyword, PageRequest pageRequest) {
//		return reviewRepo.getSearchKeyword(searchKeyword, pageRequest);
//	}

	@Override

	public void insertReview(ReviewRegistrationvo reviewRegistrationvo) {

		reviewRepo.save(reviewRegistrationvo);
	}



	@Override
	public List<ReviewRegistrationvo> selectReviewList(ReviewRegistrationvo reviewRegistrationvo) {

		JPAQueryFactory query = new JPAQueryFactory(em);

		QReviewRegistrationvo qReviewRegistrationvo = QReviewRegistrationvo.reviewRegistrationvo;

		return query.selectFrom(qReviewRegistrationvo).orderBy(qReviewRegistrationvo.reviewId.desc()).fetch();

	}

	@Override
	public List<Object> selectReviewJoinReviewAndComment(Uservo uservo, 
			ReviewRegistrationvo reviewRegistrationvo, Commentvo commentvo) {
		/*
		 * JPAQueryFactory query = new JPAQueryFactory(em); // JPAQuery<Object> query =
		 * new JPAQuery<Object>(em);
		 * 
		 * QUservo qUservo = QUservo.uservo; QReviewRegistrationvo qReviewRegistrationvo
		 * = QReviewRegistrationvo.reviewRegistrationvo; QCommentvo qCommentvo =
		 * QCommentvo.commentvo;
		 * 
		 */

		/*
		 * return query.from(qReviewRegistrationvo)
		 * .innerJoin(qReviewRegistrationvo.commentList, qCommentvo)
		 * .on(qReviewRegistrationvo.uservo.userId.eq(qCommentvo.uservo.userId))
		 * .orderBy(qReviewRegistrationvo.reviewId.desc()).fetch();
		 */
		return null;

	}

	@Override
	public ReviewRegistrationvo selectReviewView(ReviewRegistrationvo reviewRegistrationvo) {
		return reviewRepo.findById(reviewRegistrationvo.getReviewId()).get();
	}

	@Override
	public void updateReview(ReviewRegistrationvo reviewRegistrationvo) {
		ReviewRegistrationvo findReview = reviewRepo.findById(reviewRegistrationvo.getReviewId()).get();

		findReview.setTitle(reviewRegistrationvo.getTitle());
		findReview.setAdvantages(reviewRegistrationvo.getAdvantages());
		findReview.setDisadvantages(reviewRegistrationvo.getDisadvantages());
		reviewRepo.save(findReview);

	}

	@Override
	public void deleteReview(ReviewRegistrationvo reviewRegistrationvo) {
		
		reviewRepo.deleteById(reviewRegistrationvo.getReviewId());


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

	@Override
	public List<ReviewRegistrationvo> selectReviewList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Page<ReviewRegistrationvo> findAll(Pageable pageable){
		return reviewRepo.findAll(pageable);
	}
	
	public List<ReviewRegistrationvo> findAll(){
		return reviewRepo.findAll();
	}
	
	public List<ReviewRegistrationvo> getNewestReviewList(){
		return reviewRepo.getNewestReviewList();
	}
	public List<ReviewRegistrationvo> getNewestReview(){
		return (List<ReviewRegistrationvo>) reviewRepo.getNewestReview();
	}

}
