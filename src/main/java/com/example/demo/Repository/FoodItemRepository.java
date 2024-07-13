package com.example.demo.Repository;

import com.example.demo.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodItemRepository extends JpaRepository <FoodItem, Integer> {

    List<FoodItem> findAllByRestaurantId(Integer restaurantId);

    FoodItem findByFoodId(Integer foodId);
}
