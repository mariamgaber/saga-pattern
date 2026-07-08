package com.appsdeveloperblog.orders.service;

import com.saga.core.dto.Order;

import java.util.UUID;

public interface OrderService {
    Order placeOrder(Order order);
    void approveOrder(UUID orderId);
}
