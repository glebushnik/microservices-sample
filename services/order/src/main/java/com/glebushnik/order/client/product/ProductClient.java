package com.glebushnik.order.client.product;


import com.glebushnik.order.domain.DTO.purchase.PurchaseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "product-service",
        url = "${application.config.product-url}"
)
public interface ProductClient {
    @PostMapping("/purchase")
    Optional<List<PurchaseResponse>> purchaseProduct(@RequestBody List<PurchaseRequest> request);
}
