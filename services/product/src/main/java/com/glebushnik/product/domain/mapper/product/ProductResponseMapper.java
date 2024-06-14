package com.glebushnik.product.domain.mapper.product;

import com.glebushnik.product.domain.DTO.product.ProductResponse;
import com.glebushnik.product.domain.entity.Product;
import com.glebushnik.product.domain.mapper.EntityResponseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper extends EntityResponseMapper<ProductResponse, Product> {
    @Override
    Product toEntity(ProductResponse dto);

    @Override
    ProductResponse toDto(Product entity);

    @Override
    List<Product> toEntity(List<ProductResponse> dtoList);

    @Override
    List<ProductResponse> toDto(List<Product> entityList);
}
