package com.glebushnik.product.domain.mapper.product;

import com.glebushnik.product.domain.DTO.product.ProductRequest;
import com.glebushnik.product.domain.entity.Product;
import com.glebushnik.product.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper extends EntityRequestMapper<ProductRequest, Product> {
    @Override
    Product toEntity(ProductRequest dto);

    @Override
    ProductRequest toDto(Product entity);

    @Override
    List<Product> toEntity(List<ProductRequest> dtoList);

    @Override
    List<ProductRequest> toDto(List<Product> entityList);
}
