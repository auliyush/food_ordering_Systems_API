package com.example.demo.Service.ServiceImpl;
import com.example.demo.Controller.RestaurantController;
import com.example.demo.Controller.UserController;
import com.example.demo.Model.ModelRequest.OrderRequest;
import com.example.demo.Model.Order;
import com.example.demo.Model.Restaurant;
import com.example.demo.Model.User;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserController userController;
    @Autowired
    private RestaurantController restaurantController;
    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        Optional<User> user = userController.viewProfile(orderRequest.getCustomerId());
        if(user.isPresent()){
            if(restaurantController.getRestaurantById(orderRequest.getRestaurantId()) != null){
                Order order = new Order();
                order.setCustomerId(orderRequest.getCustomerId());
                order.setFoodItemId(orderRequest.getFoodItemId());
                order.setRestaurantId(orderRequest.getRestaurantId());
                order.setOrderStatus("Pending");
                return orderRepository.save(order);
            }else {
                return new Order();
            }
        }else{
            return new Order();
        }
    }
    @Override
    public List<Order> getOrderListByCustomerId(Integer customerId) {
        Optional<User> user = userController.viewProfile(customerId);
        if(user.isPresent()){
            return orderRepository.findAllByCustomerId(customerId);
        }else {
            return Collections.emptyList();
        }
    }
    @Override
    public List<Order> getListOfOrderByRestaurantId(Integer restaurantId) {
        if(restaurantController.getRestaurantById(restaurantId) != null){
           return orderRepository.findAllByRestaurantId(restaurantId);
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Order> getOrderList() {
      return orderRepository.findAll();
    }
}
