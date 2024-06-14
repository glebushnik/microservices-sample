package com.glebushnik.product.service;

import com.glebushnik.product.domain.DTO.product.ProductPurchaseRequest;
import com.glebushnik.product.domain.DTO.product.ProductRequest;
import com.glebushnik.product.domain.DTO.product.ProductResponse;
import com.glebushnik.product.domain.DTO.product.ProductPurchaseResponse;
import com.glebushnik.product.domain.mapper.product.ProductPurchaseResponseMapper;
import com.glebushnik.product.domain.mapper.product.ProductRequestMapper;
import com.glebushnik.product.domain.mapper.product.ProductResponseMapper;
import com.glebushnik.product.exception.product.ProductPurchaseException;
import com.glebushnik.product.repo.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductResponseMapper productResponseMapper;
    private final ProductRequestMapper productRequestMapper;
    private final ProductPurchaseResponseMapper productPurchaseResponseMapper;


    public ProductResponse createProduct(ProductRequest request) {
        var product = productRepo.save(productRequestMapper.toEntity(request));
        return productResponseMapper.toDto(product);
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList();

        var storedProducts = productRepo.findAllByIdInOrderById(productIds);

        if(productIds.size()!=storedProducts.size()) {
            throw new ProductPurchaseException("Один или более товаров из запроса не существует.");
        }

        var storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList();

        List<ProductPurchaseResponse> purchasedProducts = IntStream.range(0, storedProducts.size())
                .mapToObj(i -> {
                    var product = storedProducts.get(i);
                    var productRequest = storedRequest.get(i);

                    if (product.getAvailibleQuantity() < productRequest.getQuantity()) {
                        throw new ProductPurchaseException(
                                String.format("Insufficient stock quantity for product with ID: %s", product.getId())
                        );
                    }

                    var newAvailableQuantity = product.getAvailibleQuantity() - productRequest.getQuantity();
                    product.setAvailibleQuantity(newAvailableQuantity);
                    productRepo.save(product);

                    return productPurchaseResponseMapper.toDto(product);
                })
                .collect(Collectors.toList());

        return purchasedProducts;
    }

    public ProductResponse getProductById(Long productId) {
        return productRepo.findById(productId)
                .map(productResponseMapper::toDto)
                .orElseThrow(
                        ()->new EntityNotFoundException(String.format("Продукт с ID : %d не найден", productId))
                );
    }

    public List<ProductResponse> findAll() {
        return productResponseMapper.toDto(productRepo.findAll());
    }
}
