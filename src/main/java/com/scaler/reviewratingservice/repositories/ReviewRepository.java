package com.scaler.reviewratingservice.repositories;

import com.scaler.reviewratingservice.models.Review;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByDriverId(Long driverId);

    List<Review> findByRideId(Long rideId);
}
