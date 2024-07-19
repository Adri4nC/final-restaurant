package com.example.demo.controller;
import com.example.demo.model.Review;
import com.example.demo.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService ReviewService;

    @GetMapping
    public List<Review> getAllReviews() { return ReviewService.getAllReviews(); }

    @PostMapping
    public Review createReview(@RequestBody Review review) {return ReviewService.createReview(review);}

    @GetMapping("/{codeReview}")
    public Review getrestaurantById(@PathVariable Long codeReview) {
        return ReviewService.getrestaurantById(codeReview);
    }

    @PutMapping("/{codeReview}")
    public Review updateReview(@PathVariable Long codeReview, @RequestBody Review ReviewDetails) {
        return ReviewService.updateReview(codeReview, ReviewDetails);
    }

    @DeleteMapping("/{codeReview}")
    public void deleteReview(@PathVariable Long codeReview) {
        ReviewService.deleteReview(codeReview);
    }
}
