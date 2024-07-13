package com.example.demo.Model.ModelUPdateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FoodItemUpdateRequest {
    private Integer foodId;
    private Integer restaurantId;
    private String foodName;
    private String foodDescription;
    private int foodPrice;
    private boolean foodAvailability;
}
