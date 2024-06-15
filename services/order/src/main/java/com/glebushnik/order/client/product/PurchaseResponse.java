package com.glebushnik.order.client.product;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
public class PurchaseResponse {
    private Long productId;

    private String name;

    private String description;

    private BigDecimal price;

    private double quantity;
}
