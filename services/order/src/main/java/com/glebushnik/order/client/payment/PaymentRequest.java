package com.glebushnik.order.client.payment;

import com.glebushnik.order.client.customer.CustomerResponse;
import com.glebushnik.order.domain.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long orderId,
        String orderReference,
        CustomerResponse customer
) {
}
