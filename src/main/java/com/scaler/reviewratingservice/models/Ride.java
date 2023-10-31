package com.scaler.reviewratingservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ride")
public class Ride extends BaseModel {

    private String source;
    private String destination;

    @ManyToMany
    private List<User> users = new ArrayList<>();

   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "ride")
    private List<Review> reviews = new ArrayList<>();*/

}