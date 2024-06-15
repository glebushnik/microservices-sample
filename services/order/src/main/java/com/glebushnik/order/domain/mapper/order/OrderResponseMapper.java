package com.glebushnik.order.domain.mapper.order;

import com.glebushnik.order.domain.DTO.order.OrderResponse;
import com.glebushnik.order.domain.entity.Order;
import com.glebushnik.order.domain.mapper.EntityResponseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderResponseMapper extends EntityResponseMapper<OrderResponse, Order> {
    @Override
    Order toEntity(OrderResponse dto);

    @Override
    OrderResponse toDto(Order entity);

    @Override
    List<Order> toEntity(List<OrderResponse> dtoList);

    @Override
    List<OrderResponse> toDto(List<Order> entityList);
}
