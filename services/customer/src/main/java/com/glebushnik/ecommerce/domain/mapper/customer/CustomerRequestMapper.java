package com.glebushnik.ecommerce.domain.mapper.customer;

import com.glebushnik.ecommerce.domain.DTO.customer.CustomerRequest;
import com.glebushnik.ecommerce.domain.entity.Customer;
import com.glebushnik.ecommerce.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper extends EntityRequestMapper<CustomerRequest, Customer> {
    @Override
    Customer toEntity(CustomerRequest dto);

    @Override
    CustomerRequest toDto(Customer entity);

    @Override
    List<Customer> toEntity(List<CustomerRequest> dtoList);

    @Override
    List<CustomerRequest> toDto(List<Customer> entityList);
}
