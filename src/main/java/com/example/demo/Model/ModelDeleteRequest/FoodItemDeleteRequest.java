package com.example.demo.Model.ModelDeleteRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FoodItemDeleteRequest {
    private Integer foodId;
    private Integer restaurantId;
}
