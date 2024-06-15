package com.glebushnik.order.domain.DTO.order;

import com.glebushnik.order.client.customer.CustomerResponse;
import com.glebushnik.order.client.product.PurchaseResponse;
import com.glebushnik.order.domain.enums.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderConfirmation {
    private String orderReference;

    private BigDecimal totalAmount;

    private PaymentMethod paymentMethod;

    private CustomerResponse customerResponse;

    private List<PurchaseResponse> products;
}
