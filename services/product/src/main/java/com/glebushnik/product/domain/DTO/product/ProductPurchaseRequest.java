package com.glebushnik.product.domain.DTO.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductPurchaseRequest {
    @NotNull(message = "Поле 'айди продукта' не может быть пустым")
    private Long productId;

    @NotNull(message = "Поле 'количество товара' не может быть пустым")
    private double quantity;
}
