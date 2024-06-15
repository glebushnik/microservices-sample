package com.glebushnik.order.service;

import com.glebushnik.order.client.customer.CustomerClient;
import com.glebushnik.order.client.product.ProductClient;
import com.glebushnik.order.domain.DTO.order.OrderConfirmation;
import com.glebushnik.order.domain.DTO.order.OrderRequest;
import com.glebushnik.order.domain.DTO.order.OrderResponse;
import com.glebushnik.order.domain.DTO.orderline.OrderLineRequest;
import com.glebushnik.order.domain.mapper.order.OrderRequestMapper;
import com.glebushnik.order.domain.mapper.order.OrderResponseMapper;
import com.glebushnik.order.exception.BusinessException;
import com.glebushnik.order.kafka.OrderProducer;
import com.glebushnik.order.repo.OrderRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final OrderLineService orderLineService;
    private final OrderRequestMapper orderRequestMapper;
    private final OrderResponseMapper orderResponseMapper;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderProducer orderProducer;
    public OrderResponse createOrder(OrderRequest request) {
        var customer = customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(
                        ()-> new BusinessException(String.format("Невозможно создать заказ:: покупателя с ID :: %s не существует",request.getCustomerId()))
                );

        var products = productClient.purchaseProduct(request.getProducts())
                .orElseThrow(
                        ()->new BusinessException(String.format("Невозможно создать заказ."))
                );

        var order = orderRepo.save(orderRequestMapper.toEntity(request));

        request.getProducts().forEach(
                purchaseRequest -> {
                    orderLineService.saveOrderLine(
                      new OrderLineRequest(
                              null,
                              order.getId(),
                              purchaseRequest.getProductId(),
                              purchaseRequest.getQuantity()
                      )
                    );
                }
        );

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.getReference(),
                        request.getAmount(),
                        request.getPaymentMethod(),
                        customer,
                        products
                )
        );

        return orderResponseMapper.toDto(order);
    }

    public List<OrderResponse> findAll() {
        return orderResponseMapper.toDto(orderRepo.findAll());
    }


    public OrderResponse findById(Long orderId) {
        return orderResponseMapper.toDto(orderRepo.findById(orderId).orElseThrow(
                ()->new EntityNotFoundException(String.format("Заказ с ID :: %d не найден", orderId))
        ));
    }
}
