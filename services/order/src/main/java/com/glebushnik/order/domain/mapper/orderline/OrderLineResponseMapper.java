package com.glebushnik.order.domain.mapper.orderline;

import com.glebushnik.order.domain.DTO.orderline.OrderLineResponse;
import com.glebushnik.order.domain.entity.Order;
import com.glebushnik.order.domain.entity.OrderLine;
import com.glebushnik.order.domain.mapper.EntityResponseMapper;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderLineResponseMapper extends EntityResponseMapper<OrderLineResponse, OrderLine> {
    @Override
    OrderLine toEntity(OrderLineResponse dto);

    @Override
    OrderLineResponse toDto(OrderLine entity);

    @Override
    List<OrderLine> toEntity(List<OrderLineResponse> dtoList);

    @Override
    List<OrderLineResponse> toDto(List<OrderLine> entityList);
}
