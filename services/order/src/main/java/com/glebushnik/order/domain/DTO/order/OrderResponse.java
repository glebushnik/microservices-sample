package com.glebushnik.order.domain.DTO.order;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
public class OrderResponse {
    private Long id;
    private String reference;
    private BigDecimal amount;
    private String customerId;
}
