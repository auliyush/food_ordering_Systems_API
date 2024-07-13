package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.FoodItem;
import com.example.demo.Model.ModelDeleteRequest.FoodItemDeleteRequest;
import com.example.demo.Model.ModelRequest.FoodItemRequest;
import com.example.demo.Model.ModelUPdateRequest.FoodItemUpdateRequest;
import com.example.demo.Model.Restaurant;
import com.example.demo.Repository.FoodItemRepository;
import com.example.demo.Service.FoodItemService;
import com.example.demo.Service.RestaurantService;
import jakarta.persistence.ElementCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private RestaurantService restaurantService;
    @Override
    public FoodItem addFoodItem(FoodItemRequest foodItemRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(foodItemRequest.getRestaurantId());
        if(restaurant != null){
            FoodItem foodItem = new FoodItem();
            foodItem.setRestaurantId(foodItemRequest.getRestaurantId());
            foodItem.setFoodName(foodItemRequest.getFoodName());
            foodItem.setFoodPrice(foodItemRequest.getFoodPrice());
            foodItem.setFoodDescription(foodItemRequest.getFoodDescription());
            foodItem.setFoodAvailability(true);
            restaurant.getFoodItems().add(foodItem);
            return foodItemRepository.save(foodItem);
        }else {
            return null;
        }
    }
    @Override
    public FoodItem updateFoodItem(FoodItemUpdateRequest foodItemUpdateRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(foodItemUpdateRequest.getRestaurantId());
        if(restaurant != null){
            for(FoodItem fooditem :
                    foodItemRepository.findAllByRestaurantId(foodItemUpdateRequest.getRestaurantId())){
                if(fooditem.getFoodId().equals(foodItemUpdateRequest.getFoodId())){
                    fooditem.setFoodName(foodItemUpdateRequest.getFoodName());
                    fooditem.setFoodPrice(foodItemUpdateRequest.getFoodPrice());
                    fooditem.setFoodDescription(foodItemUpdateRequest.getFoodDescription());
                    fooditem.setFoodAvailability(foodItemUpdateRequest.isFoodAvailability());
                    restaurantService.saveRestaurantUpdates(restaurant);
                    return foodItemRepository.save(fooditem);
                }
            }
        }
        return null;
    }
    @Override
    public FoodItem deleteFoodItem(FoodItemDeleteRequest foodItemDeleteRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(foodItemDeleteRequest.getRestaurantId());
        if (restaurant != null) {
           FoodItem foodItem = foodItemRepository.findByFoodId(foodItemDeleteRequest.getFoodId());
           restaurant.getFoodItems().remove(foodItem);
           restaurantService.saveRestaurantUpdates(restaurant);
           return new FoodItem();
        }
        return null;
    }

    @Override
    public FoodItem getFoodItemById(Integer restaurantId,Integer foodItemId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        if(restaurant != null){
            FoodItem foodItem = foodItemRepository.findByFoodId(foodItemId);
            if (foodItem != null) {
                return foodItem;
            }
            else {
                return null;
            }
        }
        return null;
    }

    @Override
    public List<FoodItem> getListOfFoodItem(Integer restaurantId) {
//        if(restaurantService.getRestaurantById(restaurantId) != null){
//            return foodItemRepository.findAllByRestaurantId(restaurantId);
//        }else {
//            return null;
//        }
        return restaurantService.getRestaurantById(restaurantId).getFoodItems();
    }
}
