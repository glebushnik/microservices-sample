package com.glebushnik.payment.domain.dto.payment;

import com.glebushnik.payment.domain.dto.customer.Customer;
import com.glebushnik.payment.domain.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long orderId,
        String orderReference,
        Customer customer
) {
}
