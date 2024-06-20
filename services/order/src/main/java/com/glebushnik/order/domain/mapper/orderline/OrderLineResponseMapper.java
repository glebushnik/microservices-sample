package com.glebushnik.order.domain.mapper.orderline;

import com.glebushnik.order.domain.DTO.orderline.OrderLineResponse;
import com.glebushnik.order.domain.entity.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineResponseMapper {
    public OrderLineResponse toDto(OrderLine orderLine) {
        if (orderLine == null) {
            return null;
        }
        return OrderLineResponse.builder()
                .id(orderLine.getId())
                .quantity(orderLine.getQuantity())
                .build();
    }
}

