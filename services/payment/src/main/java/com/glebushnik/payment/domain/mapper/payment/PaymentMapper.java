package com.glebushnik.payment.domain.mapper.payment;

import com.glebushnik.payment.domain.dto.payment.PaymentRequest;
import com.glebushnik.payment.domain.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .orderId(request.orderId())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .build();
    }
}
