package com.example.demo.Repository;

import com.example.demo.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {

    List<Order> findAllByRestaurantId(Integer restaurantId);

    List<Order> findAllByCustomerId(Integer customerId);
}
