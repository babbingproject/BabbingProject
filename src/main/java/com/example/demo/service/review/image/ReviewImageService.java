package com.example.demo.service.review.image;

import com.example.demo.domain.review.ReviewImagevo;

public interface ReviewImageService {

	ReviewImagevo getImgById(ReviewImagevo reviewImagevo);

	ReviewImagevo getReviewImagevo(ReviewImagevo reviewImagevo);
	ReviewImagevo saveReviewImagevo(ReviewImagevo reviewImagevo);

	void insertReviewImg(ReviewImagevo reviewImagevo);
}