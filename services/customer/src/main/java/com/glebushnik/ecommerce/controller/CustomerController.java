package com.glebushnik.ecommerce.controller;

import com.glebushnik.ecommerce.domain.DTO.customer.CustomerRequest;
import com.glebushnik.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return ResponseEntity.ok().body(customerService.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(
        @RequestBody @Valid CustomerRequest request
    ) {
            customerService.updateCustomer(request);
            return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
       return ResponseEntity.ok().body(customerService.findAll());
    }

    @GetMapping("/exits/{customer-id}")
    public ResponseEntity<?> existsById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity.ok().body(customerService.existsById(customerId));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<?> findById(
            @PathVariable("customer-id") String customerId
    ) {
            return ResponseEntity.ok().body(customerService.getCustomerById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<?> deleteById(
            @PathVariable("customer-id") String customerId
    ) {
            customerService.deleteCustomerById(customerId);
            return ResponseEntity.ok().body(String.format("Покупатель с ID : %s удален.", customerId));
    }
}
