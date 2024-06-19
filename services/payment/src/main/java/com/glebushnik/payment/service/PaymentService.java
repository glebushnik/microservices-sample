package com.glebushnik.payment.service;

import com.glebushnik.payment.domain.dto.payment.PaymentNotificationRequest;
import com.glebushnik.payment.domain.dto.payment.PaymentRequest;
import com.glebushnik.payment.domain.mapper.payment.PaymentMapper;
import com.glebushnik.payment.notification.NotificationProducer;
import com.glebushnik.payment.repo.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;
    public Long createPayment(PaymentRequest request) {
        var payment = paymentRepo.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstName(),
                        request.customer().lastName(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
