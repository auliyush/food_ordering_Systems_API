package com.example.demo.Model.ModelUPdateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantUpdateRequest {
    private Integer restaurantId;
    private String restaurantName;
    private String address;
    private String phoneNumber;
}
