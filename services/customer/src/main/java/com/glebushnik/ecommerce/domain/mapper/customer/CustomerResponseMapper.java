package com.glebushnik.ecommerce.domain.mapper.customer;

import com.glebushnik.ecommerce.domain.DTO.customer.CustomerResponse;
import com.glebushnik.ecommerce.domain.entity.Customer;
import com.glebushnik.ecommerce.domain.mapper.EntityResponseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper extends EntityResponseMapper<CustomerResponse, Customer> {
    @Override
    Customer toEntity(CustomerResponse dto);

    @Override
    CustomerResponse toDto(Customer entity);

    @Override
    List<Customer> toEntity(List<CustomerResponse> dtoList);

    @Override
    List<CustomerResponse> toDto(List<Customer> entityList);
}
