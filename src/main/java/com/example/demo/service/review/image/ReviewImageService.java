package com.example.demo.service.review.image;

import java.util.List;

import com.example.demo.domain.review.AjaxReviewImagevo;
import com.example.demo.domain.review.ReviewImagevo;

public interface ReviewImageService {

   ReviewImagevo getImgById(ReviewImagevo reviewImagevo);

   ReviewImagevo getReviewImagevo(ReviewImagevo reviewImagevo);
   ReviewImagevo saveReviewImagevo(ReviewImagevo reviewImagevo);

   void insertReviewImg(ReviewImagevo reviewImagevo);

   void updateReviewImg(ReviewImagevo reviewImagevo);

   List<ReviewImagevo> getReviewImgList(int reviewId);

   void deleteModifyReviewImg(String reviewViewImgName);
   
   ReviewImagevo getReviewImagevoByImgName(String arrayshowImgSrc);

   void updateShowImgReview(ReviewImagevo reviewImagevo);

<<<<<<< HEAD
	void insertReviewImg(ReviewImagevo reviewImagevo);
	
	List<AjaxReviewImagevo> selectAjaxReviewImgList(int reviewId);

	void deleteajaxReviewImg(String ajaxReviewImage);
	
	void ajaxReviewImgUpdate(AjaxReviewImagevo ajaxReviewImagevo);
=======
>>>>>>> 5dd6a66f632fd30841ad050968d91eb8ad6add2a
}