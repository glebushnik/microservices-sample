package com.glebushnik.order.domain.mapper.order;

import com.glebushnik.order.domain.DTO.order.OrderRequest;
import com.glebushnik.order.domain.DTO.purchase.PurchaseRequest;
import com.glebushnik.order.domain.entity.Order;
import com.glebushnik.order.domain.entity.OrderLine;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderRequestMapper {
    public Order toEntity(OrderRequest request) {
        if (request == null) {
            return null;
        }

        Order order = Order.builder()
                .reference(request.getReference())
                .totalAmount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .customerId(request.getCustomerId())
                .orderLines(request.getProducts().stream()
                        .map(this::toOrderLine)
                        .collect(Collectors.toList()))
                .build();

        order.getOrderLines().forEach(orderLine -> orderLine.setOrder(order));

        return order;
    }

    private OrderLine toOrderLine(PurchaseRequest purchaseRequest) {
        return OrderLine.builder()
                .productId(purchaseRequest.getProductId())
                .quantity(purchaseRequest.getQuantity())
                .build();
    }

}
