package com.example.demo.Model.ModelRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantRequest {
    private Integer ownerId;
    private String restaurantName;
    private String address;
    private String phoneNumber;
}
