package com.glebushnik.product.domain.mapper.product;

import com.glebushnik.product.domain.DTO.product.ProductPurchaseResponse;
import com.glebushnik.product.domain.entity.Product;
import com.glebushnik.product.domain.mapper.EntityResponseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPurchaseResponseMapper extends EntityResponseMapper<ProductPurchaseResponse, Product> {
    @Override
    Product toEntity(ProductPurchaseResponse dto);

    @Override
    ProductPurchaseResponse toDto(Product entity);

    @Override
    List<Product> toEntity(List<ProductPurchaseResponse> dtoList);

    @Override
    List<ProductPurchaseResponse> toDto(List<Product> entityList);
}
