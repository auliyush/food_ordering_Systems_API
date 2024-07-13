package com.example.demo.Service;

import com.example.demo.Model.FoodItem;
import com.example.demo.Model.ModelDeleteRequest.FoodItemDeleteRequest;
import com.example.demo.Model.ModelRequest.FoodItemRequest;
import com.example.demo.Model.ModelUPdateRequest.FoodItemUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface FoodItemService {
    FoodItem addFoodItem(FoodItemRequest foodItemRequest);
    List<FoodItem> getListOfFoodItem(Integer restaurantId);

    FoodItem updateFoodItem(FoodItemUpdateRequest foodItemUpdateRequest);

    FoodItem deleteFoodItem(FoodItemDeleteRequest foodItemDeleteRequest);

    FoodItem getFoodItemById(Integer restaurantId, Integer foodItemId);

}
