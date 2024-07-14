package com.example.demo.Controller;

import com.example.demo.Model.ModelRequest.OrderRequest;
import com.example.demo.Model.ModelUPdateRequest.OrderUpdateRequest;
import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody OrderRequest orderRequest){
        return orderService.placeOrder(orderRequest);
    }
    @PutMapping("/update/orderStatus")
    public Order updateOrderStatus(@RequestBody OrderUpdateRequest orderUpdateRequest){
        return orderService.updateOrderStatus(orderUpdateRequest);
    }
    @GetMapping("/customer/orderList")
    public List<Order> getOrderListByCustomerId(@RequestParam Integer customerId){
        return orderService.getOrderListByCustomerId(customerId);
    }
    @GetMapping("/restaurant/orderList")
    public List<Order> getListOfOrderByRestaurantId(@RequestParam Integer restaurantId){
        return orderService.getListOfOrderByRestaurantId(restaurantId);
    }
    @GetMapping("/orderList")
    public List<Order> getOrderList(){
        return orderService.getOrderList();
    }
}
