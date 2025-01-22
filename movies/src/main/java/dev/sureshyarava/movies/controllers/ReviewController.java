package dev.sureshyarava.movies.controllers;

import dev.sureshyarava.movies.models.Review;
import dev.sureshyarava.movies.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/")
    public ResponseEntity<Review> createReviewMethod(@RequestBody Map<String, String> payload){
        return new ResponseEntity<>(reviewService.createReview(payload.get("body"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
