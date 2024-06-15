package com.glebushnik.order.domain.DTO.orderline;

import lombok.*;

@Data
@Getter
@Setter
@Builder
public class OrderLineResponse {
    public Long id;
    public double quantity;
}
