package com.example.demo.Model.ModelRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FoodItemRequest {
    private Integer restaurantId;
    private String foodName;
    private String foodDescription;
    private int foodPrice;
}
