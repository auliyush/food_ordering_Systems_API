package com.example.demo.Controller;

import com.example.demo.Model.FoodItem;
import com.example.demo.Model.ModelDeleteRequest.FoodItemDeleteRequest;
import com.example.demo.Model.ModelRequest.FoodItemRequest;
import com.example.demo.Model.ModelUPdateRequest.FoodItemUpdateRequest;
import com.example.demo.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/foodItem")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/add/FoodItem")
    public FoodItem addFoodItem(@RequestBody FoodItemRequest foodItemRequest){
        return foodItemService.addFoodItem(foodItemRequest);
    }
    @PutMapping("/update/foodItem")
    public FoodItem updateFoodItem(@RequestBody FoodItemUpdateRequest foodItemUpdateRequest){
        return foodItemService.updateFoodItem(foodItemUpdateRequest);
    }
    @DeleteMapping("/delete/foodItem")
    public FoodItem deleteFoodItem(@RequestBody FoodItemDeleteRequest foodItemDeleteRequest){
        return foodItemService.deleteFoodItem(foodItemDeleteRequest);
    }
    @GetMapping("/get/foodItem/by/Id")
    public FoodItem getFoodItemById(@RequestParam Integer restaurantId, Integer foodItemId){
        return foodItemService.getFoodItemById(restaurantId,foodItemId);
    }
    @GetMapping("/list/ofFoodItem")
    public List<FoodItem> getListOfFoodItem(@RequestParam Integer restaurantId){
        return foodItemService.getListOfFoodItem(restaurantId);
    }
}
