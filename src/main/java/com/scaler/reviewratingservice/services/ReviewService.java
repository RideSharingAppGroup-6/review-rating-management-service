package com.scaler.reviewratingservice.services;

import com.scaler.reviewratingservice.dtos.ReviewRequestDto;
import com.scaler.reviewratingservice.models.Review;
import com.scaler.reviewratingservice.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    ReviewRepository reviewRepository;
    public Review createReview(ReviewRequestDto request, Long driverId) {

        Review review = new Review();
        review.setComment(request.getComment());
        review.setRating(request.getRating());
        review.setUserId(request.getUserId());
        review.setRideId(request.getRideId());
        review.setDriverId(driverId);

        return reviewRepository.save(review);
    }

    public Review getReview(Long reviewId) {

        return reviewRepository.findById(reviewId).get();
    }

    public Double getAverageRatingByDriverId(Long driverId) {

        List<Review> reviews = reviewRepository.findByDriverId(driverId);
        double sum = 0, cnt = 0;
        for (Review review : reviews) {
            if (review.getRating() != null) {
                sum = sum + review.getRatingNumericalValue();
                cnt++;
            }
        }

        if (cnt > 0)
            return sum/cnt;

        return 0.0;
    }

    public Double getAverageRatingByRideId(Long rideId) {

        List<Review> reviews = reviewRepository.findByRideId(rideId);
        double sum = 0, cnt = 0;
        for (Review review : reviews) {
            if (review.getRating() != null) {
                sum = sum + review.getRatingNumericalValue();
                cnt++;
            }
        }

        if (cnt > 0)
            return sum/cnt;

        return 0.0;
    }
}
