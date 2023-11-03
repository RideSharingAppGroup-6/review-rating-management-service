package com.scaler.reviewratingservice.dtos;

import com.scaler.reviewratingservice.models.Rating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDto {

    private String comment;
    private Long userId;
    private Long rideId;
    private Rating rating;
}
