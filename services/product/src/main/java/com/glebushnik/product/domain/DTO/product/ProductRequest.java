package com.glebushnik.product.domain.DTO.product;

import com.glebushnik.product.domain.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    @NotNull(message = "Поле 'название товара' не может быть пустым.")
    private String name;

    @NotNull(message = "Поле 'описание товара' не может быть пустым.")
    private String description;

    @Positive(message = "Поле 'количество товара' не может быть отрицательным.")
    private Double available;

    @Positive(message = "Поле 'цена' не может быть отрицательным.")
    private BigDecimal price;

    @NotNull(message = "Поле 'категория' не может быть пустым.")
    private Long categoryId;
}
