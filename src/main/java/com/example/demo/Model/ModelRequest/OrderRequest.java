package com.example.demo.Model.ModelRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OrderRequest {
    private Integer customerId;
    private Integer restaurantId;
    private Integer foodItemId;
}
