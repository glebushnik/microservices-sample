package com.glebushnik.order.domain.DTO.purchase;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class PurchaseRequest {
    @NotNull(message = "Поле 'productId' не может быть пустым.")
    private Long productId;

    @Positive(message = "Поле 'количество товара' не может быть отрицательным.")
    private double quantity;
}
