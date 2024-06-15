package com.glebushnik.order.domain.DTO.orderline;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineRequest {
    public Long id;
    public Long orderId;
    public Long productId;
    public double quantity;
}
