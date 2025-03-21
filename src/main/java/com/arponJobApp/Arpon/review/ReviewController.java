package com.arponJobApp.Arpon.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        List<Review> reviews = reviewService.getAllReviews(companyId);
        return ResponseEntity.ok(reviews);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review) {

           boolean isReviewSaved = reviewService.addReview(companyId, review);
           if(isReviewSaved)
           {
               return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
           }
           else {

            return new ResponseEntity<>("Review Not found or saved or company not found", HttpStatus.OK);
           }
    }

}
