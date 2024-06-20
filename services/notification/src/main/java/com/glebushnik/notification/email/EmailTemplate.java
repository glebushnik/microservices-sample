package com.glebushnik.notification.email;

import lombok.Getter;

public enum EmailTemplate {
    PAYMENT_CONFIRMATION("payment-confirmation.html", "Подтверждение оплаты."),
    ORDER_CONFIRMATION("order-confirmation.html", "Подтверждение заказа."),
    ;
    @Getter
    private final String template;
    @Getter
    private final String subject;

    EmailTemplate(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
