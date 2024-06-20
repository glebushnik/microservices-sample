package com.glebushnik.order.domain.mapper.orderline;

import com.glebushnik.order.domain.DTO.orderline.OrderLineRequest;
import com.glebushnik.order.domain.entity.Order;
import com.glebushnik.order.domain.entity.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineRequestMapper {
    public OrderLine toEntity(OrderLineRequest orderLineRequest) {
        if (orderLineRequest == null) {
            return null;
        }

        OrderLine orderLine = new OrderLine();
        orderLine.setProductId(orderLineRequest.productId);
        orderLine.setQuantity(orderLineRequest.quantity);

        if (orderLineRequest.orderId != null) {
            Order order = new Order();
            order.setId(orderLineRequest.orderId);
            orderLine.setOrder(order);
        }

        return orderLine;
    }

}
