package com.example.demo.Service.ServiceImpl;
import com.example.demo.Model.ModelRequest.OrderRequest;
import com.example.demo.Model.ModelUPdateRequest.OrderUpdateRequest;
import com.example.demo.Model.Order;
import com.example.demo.Model.User;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Service.FoodItemService;
import com.example.demo.Service.OrderService;
import com.example.demo.Service.RestaurantService;
import com.example.demo.Service.UserService;
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
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private FoodItemService foodItemService;
    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        Optional<User> user = userService.findById(orderRequest.getCustomerId());
        if(user.isPresent()){
            if(restaurantService.getRestaurantById(orderRequest.getRestaurantId()) != null){
                if(foodItemService.getFoodItemById(orderRequest.getRestaurantId(),orderRequest.getFoodItemId()) != null){
                    Order order = new Order();
                    order.setCustomerId(orderRequest.getCustomerId());
                    order.setFoodItemId(orderRequest.getFoodItemId());
                    order.setRestaurantId(orderRequest.getRestaurantId());
                    order.setOrderStatus("Pending");
                    getOrderByCustomerId(orderRequest.getCustomerId()).getFoodItemList().
                            add(foodItemService.getFoodItemById(orderRequest.getRestaurantId(),
                                    orderRequest.getFoodItemId()));
                    return orderRepository.save(order);
                }else {
                    return new Order();
                }
            }else {
                return new Order();
            }
        }else{
            return new Order();
        }
    }

    @Override
    public Order updateOrderStatus(OrderUpdateRequest orderUpdateRequest) {
        Order order = getOrderById(orderUpdateRequest.getOrderId());
        order.setOrderStatus(orderUpdateRequest.getOrderStatus());
       return orderRepository.save(order);
    }

    public Order getOrderById(Integer orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public Order getOrderByCustomerId(Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Order> getOrderListByCustomerId(Integer customerId) {
        Optional<User> user = userService.findById(customerId);
        if(user.isPresent()){
            return orderRepository.findAllByCustomerId(customerId);
        }else {
            return Collections.emptyList();
        }
    }
    @Override
    public List<Order> getListOfOrderByRestaurantId(Integer restaurantId) {
        if(restaurantService.getRestaurantById(restaurantId) != null){
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
