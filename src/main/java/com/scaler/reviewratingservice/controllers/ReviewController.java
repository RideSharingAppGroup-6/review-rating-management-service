package com.scaler.reviewratingservice.controllers;

import com.scaler.reviewratingservice.MyLogger;
import com.scaler.reviewratingservice.dtos.ReviewRequestDto;
import com.scaler.reviewratingservice.dtos.ReviewResponseDto;
import com.scaler.reviewratingservice.models.Review;
import com.scaler.reviewratingservice.services.ReviewService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private static final Logger logger = MyLogger.getLogger();
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable("reviewId") Long reviewId) {
        try {
            Review review = reviewService.getReview(reviewId);
            if (review != null) {
                return ResponseEntity.ok(review);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e) {
            logger.error("Error occurred while fetching review", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the review.");
        }
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<Double> getAverageRatingByDriverId(@PathVariable("driverId") Long driverId) {
        Double driversAverageRating = reviewService.getAverageRatingByDriverId(driverId);
        return ResponseEntity.ok(driversAverageRating);
    }

    @GetMapping("/ride/{rideId}")
    public ResponseEntity<Double> getAverageRatingByRideId(@PathVariable("rideId") Long rideId) {
        Double ridesAverageRating = reviewService.getAverageRatingByRideId(rideId);
        return ResponseEntity.ok(ridesAverageRating);
    }

    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(@RequestBody ReviewRequestDto reviewRequestDto) {

        /*
        WebClient / RestTemplate
        @Autowired
        RideService rideService;
        Optional<Ride> rideOptional = rideService.findById(id);
        Ride ride = rideOptional.get();
        Long driverId = ride.getDriverId();
        */
        Long driverId = 101L;
        Review review = reviewService.createReview(reviewRequestDto, driverId);

        ReviewResponseDto response = new ReviewResponseDto(review.getId(), "Review is submitted successfully.");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
