package com.glebushnik.payment.domain.dto.payment;

import com.glebushnik.payment.domain.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
       BigDecimal amount,
       PaymentMethod paymentMethod,
       String customerFirstName,
       String customerLastName,
       String customerEmail
) {
}
