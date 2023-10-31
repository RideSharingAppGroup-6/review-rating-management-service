package com.scaler.reviewratingservice.controllers;

import com.scaler.reviewratingservice.dtos.ReviewRequestDto;
import com.scaler.reviewratingservice.dtos.ReviewResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {


    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(@RequestBody ReviewRequestDto reviewRequestDto ) {
        return ResponseEntity.ok(new ReviewResponseDto("Review is submitted successfully."));
    }
}
