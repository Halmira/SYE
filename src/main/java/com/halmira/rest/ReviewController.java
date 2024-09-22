package com.halmira.rest;


import com.halmira.model.Review;
import com.halmira.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{companyId}/add")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review)
    {
        review.setCompanyId(companyId);
        reviewService.addReview(review);
        return ResponseEntity.ok("Successfully added your review.");
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<Review>> reviewsByCompanyId(@PathVariable Long companyId)
    {
        return ResponseEntity.ok(reviewService.getReviewsByCompanyId(companyId));
    }

    @PostMapping("/{reviewId}/upvote")
    public ResponseEntity<String> upvoteReview(@PathVariable Long reviewId) {
        reviewService.upvoteReview(reviewId);
        return ResponseEntity.ok("Review upvoted successfully.");
    }

    @PostMapping("/{reviewId}/downvote")
    public ResponseEntity<String> downvoteReview(@PathVariable Long reviewId) {
        reviewService.downvoteReview(reviewId);
        return ResponseEntity.ok("Review downvoted successfully.");
    }

}
