package com.glebushnik.ecommerce.domain.DTO.customer;

import com.glebushnik.ecommerce.domain.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String id;

    @NotNull(message = "Поле имя не может быть пустым.")
    private String firstName;

    @NotNull(message = "Поле фамилия не может быть пустой.")
    private String lastName;

    @NotNull(message = "Поле почта не может быть пустой.")
    @Email(message = "Введите корректный email.")
    private String email;

    private Address address;
}

