package com.glebushnik.order.domain.mapper.order;

import com.glebushnik.order.domain.DTO.order.OrderRequest;
import com.glebushnik.order.domain.entity.Order;
import com.glebushnik.order.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderRequestMapper extends EntityRequestMapper<OrderRequest, Order> {
    @Override
    Order toEntity(OrderRequest dto);

    @Override
    OrderRequest toDto(Order entity);

    @Override
    List<Order> toEntity(List<OrderRequest> dtoList);

    @Override
    List<OrderRequest> toDto(List<Order> entityList);
}
