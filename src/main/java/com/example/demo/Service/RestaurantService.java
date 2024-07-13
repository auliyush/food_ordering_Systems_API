package com.example.demo.Service;

import com.example.demo.Model.FoodItem;
import com.example.demo.Model.ModelRequest.RestaurantRequest;
import com.example.demo.Model.Order;
import com.example.demo.Model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Restaurant addRestaurant(RestaurantRequest restaurantRequest);

    Restaurant getRestaurantById(Integer restaurantId);

    Restaurant getRestaurantByOwnerId(Integer ownerId);

   List<Restaurant> getAllRestaurant();

    void saveRestaurantUpdates(Restaurant restaurantById);
}
