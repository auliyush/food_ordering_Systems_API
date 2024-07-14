package com.example.demo.Service;

import com.example.demo.Model.ModelRequest.OrderRequest;
import com.example.demo.Model.ModelUPdateRequest.OrderUpdateRequest;
import com.example.demo.Model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(OrderRequest orderRequest);

    List<Order> getOrderListByCustomerId(Integer customerId);

    List<Order> getOrderList();

    List<Order> getListOfOrderByRestaurantId(Integer restaurantId);

    Order updateOrderStatus(OrderUpdateRequest orderUpdateRequest);
   Order getOrderById(Integer orderId);
    Order getOrderByCustomerId(Integer orderId);
}
