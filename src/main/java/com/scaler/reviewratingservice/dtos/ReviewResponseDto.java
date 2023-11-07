package com.scaler.reviewratingservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReviewResponseDto {

    private Long reviewId;
    private String message;
}
