package com.glebushnik.order.service;

import com.glebushnik.order.domain.DTO.orderline.OrderLineRequest;
import com.glebushnik.order.domain.DTO.orderline.OrderLineResponse;
import com.glebushnik.order.domain.mapper.orderline.OrderLineRequestMapper;
import com.glebushnik.order.domain.mapper.orderline.OrderLineResponseMapper;
import com.glebushnik.order.repo.OrderLineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepo orderLineRepo;
    private final OrderLineRequestMapper orderLineRequestMapper;
    private final OrderLineResponseMapper orderLineResponseMapper;
    public OrderLineResponse saveOrderLine(OrderLineRequest orderLineRequest) {
        var orderLine = orderLineRequestMapper.toEntity(orderLineRequest);
        return orderLineResponseMapper.toDto(orderLineRepo.save(orderLine));
    }
}
