package com.example.demo.service.review.image;

import java.util.List;

<<<<<<< HEAD
=======
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

>>>>>>> 5dd6a66f632fd30841ad050968d91eb8ad6add2a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.review.AjaxReviewImagevo;
import com.example.demo.domain.review.ReviewImagevo;

@Service
public class ReviewImageServiceImpl implements ReviewImageService {

	@Autowired
	ReviewImageRepository reviewImageRepo;

	@Autowired
	
	@PersistenceUnit
    EntityManagerFactory emf;
	
<<<<<<< HEAD
	@Autowired
	AjaxReviewImageRepository ajaxReviewImageRepo;
	
	
=======
	@PersistenceContext
	EntityManager em;

>>>>>>> 5dd6a66f632fd30841ad050968d91eb8ad6add2a
	@Override
	public ReviewImagevo getImgById(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.findById(reviewImagevo.getImgId()).get();
	}

	@Override
	public ReviewImagevo getReviewImagevo(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.findById(reviewImagevo.getImgId()).get();
	}

	public ReviewImagevo saveReviewImagevo(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.save(reviewImagevo);

	}

	@Override
	public void insertReviewImg(ReviewImagevo reviewImagevo) {
		reviewImageRepo.save(reviewImagevo);

	}


	@Override
	public void updateReviewImg(ReviewImagevo reviewImagevo) {
		reviewImageRepo.save(reviewImagevo);
	}

	@Override
	public List<ReviewImagevo> getReviewImgList(int reviewId) {
		return reviewImageRepo.selectReviewImgList(reviewId);
	}
	
	/*
	 * @Override public List<ReviewImagevo> getAjaxReviewImgList(int reviewId) {
	 * 
	 * return null; }
	 */

	@Override
	public void deleteModifyReviewImg(String reviewViewImgName) {
		reviewImageRepo.deleteReviewViewImg(reviewViewImgName);
	}

	@Override
	public ReviewImagevo getReviewImagevoByImgName(String arrayshowImgSrc) {
		
		
		return reviewImageRepo.selectReviewImagevoByImgName(arrayshowImgSrc);
	}

	@Override
	public void updateShowImgReview(ReviewImagevo reviewImagevo) {
		reviewImageRepo.save(reviewImagevo);
	}
<<<<<<< HEAD
	@Override
	public List<AjaxReviewImagevo> selectAjaxReviewImgList(int reviewId) {
		
		
		return ajaxReviewImageRepo.getReviewImg(reviewId);
		
	}

	@Override
	public void deleteajaxReviewImg(String ajaxReviewImage) {
		ajaxReviewImageRepo.deleteAjaxReviewImg(ajaxReviewImage);
	}

	@Override
	public void ajaxReviewImgUpdate(AjaxReviewImagevo ajaxReviewImagevo) {
		
		ajaxReviewImageRepo.save(ajaxReviewImagevo);
	}
}
=======


	/*
	 * @Override public Optional<ReviewImagevo> getReviewImgCheakOne(int reviewId) {
	 * return reviewImageRepo.findById(reviewId); }
	 */
}
>>>>>>> 5dd6a66f632fd30841ad050968d91eb8ad6add2a
