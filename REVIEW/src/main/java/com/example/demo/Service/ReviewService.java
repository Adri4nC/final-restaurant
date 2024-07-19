package com.example.demo.Service;
import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository ReviewRepository;

    public List<Review> getAllReviews() {
        return ReviewRepository.findAll();
    }

    public Review createReview (Review review) {
        return ReviewRepository.save(review);
    }

    public Review getrestaurantById(Long codeReview) {
        return ReviewRepository.findById(codeReview)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + codeReview));
    }

    public Review updateReview(Long codeReview, Review ReviewDetails) {
        Review review = ReviewRepository.findById(codeReview)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + codeReview));

        review.setCodeBooking(ReviewDetails.getCodeBooking());
        review.setQuialification(review.getQuialification());
        review.setComment(review.getComment());
        review.setDate(review.getDate());

        return ReviewRepository.save(review);
    }

    public void deleteReview(Long codeReview) {
        ReviewRepository.deleteById(codeReview);
    }
}
