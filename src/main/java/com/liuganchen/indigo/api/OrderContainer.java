package com.liuganchen.indigo.api;

import com.liuganchen.indigo.entity.Order;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderContainer {
    @PutMapping
    public Object addNewOrder(Order order) {
        return null;
    }
}
