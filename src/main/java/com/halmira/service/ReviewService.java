package com.halmira.service;


import com.halmira.model.Review;
import com.halmira.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review)
    {
        return reviewRepository.save(review);
    }

    public void upvoteReview(Long reviewId)
    {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null)
        {
            review.setUpvotes(review.getUpvotes() + 1);
            reviewRepository.save(review);
        }
    }

    public void downvoteReview(Long reviewId)
    {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null)
        {
            review.setUpvotes(review.getUpvotes() - 1);
            reviewRepository.save(review);
        }

    }

    public List<Review> getReviewsByCompanyId(Long companyId)
    {
        return reviewRepository.findByCompanyId(companyId);
    }
}
