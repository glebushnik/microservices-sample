package com.glebushnik.payment.domain.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
    String id,
    @NotNull(message = "Поле 'имя' обязательно для заполнения.")
    String firstName,
    @NotNull(message = "Поле 'фамилия' обязательно для заполнения.")
    String lastName,
    @NotNull(message = "Поле 'почта' обязательно для заполнения.")
    @Email(message = "Некорректный формат почты.")
    String email
) {
}
