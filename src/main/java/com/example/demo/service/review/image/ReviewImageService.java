package com.example.demo.service.review.image;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.review.ReviewImagevo;

public interface ReviewImageService {

   Optional<ReviewImagevo> getImgById(int findImgId);

   ReviewImagevo getReviewImagevo(ReviewImagevo reviewImagevo);
   ReviewImagevo saveReviewImagevo(ReviewImagevo reviewImagevo);

   void insertReviewImg(ReviewImagevo reviewImagevo);

   void updateReviewImg(ReviewImagevo reviewImagevo);

   List<ReviewImagevo> getReviewImgList(int reviewId);

   void deleteModifyReviewImg(String reviewViewImgName);
   
   ReviewImagevo getReviewImagevoByImgName(String arrayshowImgSrc);

   void updateShowImgReview(ReviewImagevo reviewImagevo);

}