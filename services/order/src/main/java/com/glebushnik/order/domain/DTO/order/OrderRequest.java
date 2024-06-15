package com.glebushnik.order.domain.DTO.order;

import com.glebushnik.order.domain.DTO.purchase.PurchaseRequest;
import com.glebushnik.order.domain.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@Getter
@Setter
public class OrderRequest {
    private String reference;

    @Positive(message = "Поле 'Сумма заказа' должна быть положительной.")
    private BigDecimal amount;

    @NotNull(message = "Поле 'Способ оплаты' не может быть пустым.")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Поле 'CustomerId' не может быть пустым.")
    @NotEmpty(message = "Поле 'CustomerId' не может быть пустым.")
    @NotBlank(message = "Поле 'CustomerId' не может быть пустым.")
    private String customerId;

    @NotEmpty(message = "Вы должны выбрать хотя бы один продукт")
    private List<PurchaseRequest> products;
}
