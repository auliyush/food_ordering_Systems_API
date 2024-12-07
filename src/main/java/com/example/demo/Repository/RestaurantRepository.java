package com.example.demo.Repository;

import com.example.demo.Model.Order;
import com.example.demo.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository <Restaurant, Integer> {
    boolean existsByPhoneNumber(String restaurantName);

    Restaurant findByOwnerId(Integer ownerId);

    Restaurant findByRestaurantId(Integer restaurantId);
}
