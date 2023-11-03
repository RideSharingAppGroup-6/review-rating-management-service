package com.scaler.reviewratingservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review extends BaseModel {

    private String comment;

    private Long rideId;

    private Long userId;

    private Long driverId;

    @Enumerated
    private Rating rating;
}
