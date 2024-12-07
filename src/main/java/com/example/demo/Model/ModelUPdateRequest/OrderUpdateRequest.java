package com.example.demo.Model.ModelUPdateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderUpdateRequest {
    private Integer orderId;
    private String orderStatus;

}
