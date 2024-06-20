package com.glebushnik.order.domain.mapper.order;

import com.glebushnik.order.domain.DTO.order.OrderResponse;
import com.glebushnik.order.domain.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderResponseMapper {
    public OrderResponse toDto(Order order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .id(order.getId())
                .reference(order.getReference())
                .amount(order.getTotalAmount())
                .customerId(order.getCustomerId())
                .build();
    }
}
