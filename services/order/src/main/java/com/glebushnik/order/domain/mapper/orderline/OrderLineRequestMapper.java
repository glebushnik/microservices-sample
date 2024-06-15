package com.glebushnik.order.domain.mapper.orderline;

import com.glebushnik.order.domain.DTO.orderline.OrderLineRequest;
import com.glebushnik.order.domain.entity.OrderLine;
import com.glebushnik.order.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderLineRequestMapper extends EntityRequestMapper<OrderLineRequest, OrderLine> {
    @Override
    OrderLine toEntity(OrderLineRequest dto);

    @Override
    OrderLineRequest toDto(OrderLine entity);

    @Override
    List<OrderLine> toEntity(List<OrderLineRequest> dtoList);

    @Override
    List<OrderLineRequest> toDto(List<OrderLine> entityList);
}
