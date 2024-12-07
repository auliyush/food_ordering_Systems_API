package com.example.demo.Controller;
import com.example.demo.Model.FoodItem;
import com.example.demo.Model.ModelRequest.RestaurantRequest;
import com.example.demo.Model.ModelUPdateRequest.RestaurantUpdateRequest;
import com.example.demo.Model.Order;
import com.example.demo.Model.Restaurant;
import com.example.demo.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create/restaurant")
    public Restaurant addRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        return restaurantService.addRestaurant(restaurantRequest);
    }
    @PutMapping("/update/restaurant")
    public Restaurant updateRestaurant(@RequestBody RestaurantUpdateRequest restaurantUpdateRequest){
        return restaurantService.updateRestaurant(restaurantUpdateRequest);
    }
    @GetMapping("/get/restaurantBy/Id")
    public Restaurant getRestaurantById(@RequestParam Integer restaurantId){
        return restaurantService.getRestaurantById(restaurantId);
    }
    @GetMapping("/get/restaurantBy/ownerId")
    public Restaurant getRestaurantByOwnerId(@RequestParam Integer ownerId){
        return restaurantService.getRestaurantByOwnerId(ownerId);
    }

    @GetMapping("/get/allRestaurant")
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

}
