package com.glebushnik.order.controller;

import com.glebushnik.order.domain.DTO.order.OrderRequest;
import com.glebushnik.order.domain.DTO.order.OrderResponse;
import com.glebushnik.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody @Valid OrderRequest request
    ) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }
}
