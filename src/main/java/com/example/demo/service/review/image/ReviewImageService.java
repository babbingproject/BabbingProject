package com.example.demo.service.review.image;

import java.util.List;

import com.example.demo.domain.review.AjaxReviewImagevo;
import com.example.demo.domain.review.ReviewImagevo;

public interface ReviewImageService {

   ReviewImagevo getImgById(ReviewImagevo reviewImagevo);

   ReviewImagevo getReviewImagevo(ReviewImagevo reviewImagevo);
   ReviewImagevo saveReviewImagevo(ReviewImagevo reviewImagevo);

   void insertReviewImg(ReviewImagevo reviewImagevo);
   
   List<AjaxReviewImagevo> getAjaxReviewImgList(int reviewId);

   void deleteajaxReviewImg(String ajaxReviewImage);
   
   void ajaxReviewImgUpdate(AjaxReviewImagevo ajaxReviewImagevo);

   void updateReviewImg(ReviewImagevo reviewImagevo);

   List<ReviewImagevo> getReviewImgList(int reviewId);

   void deleteAjaxImgUploadFinished(int deleteUploadedAjaxReviewId);

//   ReviewImagevo getReviewImgCheakOne(int reviewId);
}