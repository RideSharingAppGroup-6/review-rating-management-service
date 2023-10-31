package com.scaler.reviewratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class ReviewRatingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewRatingServiceApplication.class, args);
    }

}
