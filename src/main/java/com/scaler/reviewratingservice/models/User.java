package com.scaler.reviewratingservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

@Entity
public class User extends BaseModel{

    private String username;
    private String email;
    private String phone;
    @Enumerated
    private UserType userType;
}
