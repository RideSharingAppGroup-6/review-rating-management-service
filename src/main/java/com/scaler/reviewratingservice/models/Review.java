package com.scaler.reviewratingservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review extends BaseModel {

    private String comment;

    private Long rideId;

    private Long userId;

    private Long driverId;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    public int getRatingNumericalValue() {
        return rating.getNumericValue();
    }
}
