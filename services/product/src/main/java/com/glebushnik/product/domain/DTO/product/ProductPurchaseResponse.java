package com.glebushnik.product.domain.DTO.product;

import com.glebushnik.product.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductPurchaseResponse {
    private String name;

    private String description;

    private Double available;

    private BigDecimal price;

    private Category category;
}
