package com.scaler.reviewratingservice.dtos;

import com.scaler.reviewratingservice.models.Rating;
import com.scaler.reviewratingservice.models.Ride;
import com.scaler.reviewratingservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDto {

    private String description;
    private User user;
    private Ride ride;
    private Rating rating;
}
