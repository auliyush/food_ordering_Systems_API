package com.example.demo.Service.ServiceImpl;

import com.example.demo.Controller.UserController;
import com.example.demo.Model.FoodItem;
import com.example.demo.Model.ModelRequest.RestaurantRequest;
import com.example.demo.Model.ModelUPdateRequest.RestaurantUpdateRequest;
import com.example.demo.Model.Restaurant;
import com.example.demo.Model.User;
import com.example.demo.Repository.RestaurantRepository;
import com.example.demo.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private UserController userController;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Override
    public Restaurant addRestaurant(RestaurantRequest restaurantRequest) {
        Optional<User> user = userController.viewProfile(restaurantRequest.getOwnerId());
       if(user.isPresent()){
           if(user.get().getUserRole().equalsIgnoreCase("owner")){
               if(getRestaurantByOwnerId(restaurantRequest.getOwnerId()) == null){
                   if(!restaurantRepository.existsByPhoneNumber(restaurantRequest.getPhoneNumber())){
                       Restaurant restaurant = new Restaurant();
                       restaurant.setOwnerId(restaurantRequest.getOwnerId());
                       restaurant.setRestaurantName(restaurantRequest.getRestaurantName());
                       restaurant.setPhoneNumber(restaurantRequest.getPhoneNumber());
                       restaurant.setAddress(restaurantRequest.getAddress());
                       return restaurantRepository.save(restaurant);
                   }else {
                       return null;
                   }
               }
           }
       }
        return null;
    }

    @Override
    public Restaurant updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) {
        Restaurant restaurant = getRestaurantById(restaurantUpdateRequest.getRestaurantId());
        if(restaurant != null){
            if(!restaurantRepository.existsByPhoneNumber(restaurantUpdateRequest.getPhoneNumber())){
                restaurant.setRestaurantName(restaurantUpdateRequest.getRestaurantName());
                restaurant.setPhoneNumber(restaurantUpdateRequest.getPhoneNumber());
                restaurant.setAddress(restaurantUpdateRequest.getAddress());
                saveRestaurantUpdates(restaurant);
                return restaurant;
            }
        }
        return new Restaurant();
    }

    @Override
    public Restaurant getRestaurantById(Integer restaurantId) {
        return restaurantRepository.findByRestaurantId(restaurantId);
    }
    @Override
    public Restaurant getRestaurantByOwnerId(Integer ownerId) {
        return restaurantRepository.findByOwnerId(ownerId);
    }

    @Override
    public void saveRestaurantUpdates(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
