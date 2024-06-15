package com.glebushnik.order.domain.DTO.orderline;

import lombok.*;

@Data
@Getter
@Setter
@Builder
public class OrderLineResponse {
    public Long id;
    public Long orderId;
    public Long productId;
    public double quantity;
}
