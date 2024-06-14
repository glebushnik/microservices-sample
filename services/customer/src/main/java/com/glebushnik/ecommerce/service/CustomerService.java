package com.glebushnik.ecommerce.service;

import com.glebushnik.ecommerce.domain.DTO.customer.CustomerRequest;
import com.glebushnik.ecommerce.domain.DTO.customer.CustomerResponse;
import com.glebushnik.ecommerce.domain.entity.Customer;
import com.glebushnik.ecommerce.domain.mapper.customer.CustomerRequestMapper;
import com.glebushnik.ecommerce.domain.mapper.customer.CustomerResponseMapper;
import com.glebushnik.ecommerce.exception.CustomerNotFoundByIdException;
import com.glebushnik.ecommerce.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerRequestMapper customerRequestMapper;
    private final CustomerResponseMapper customerResponseMapper;
    public CustomerResponse createCustomer(CustomerRequest request) {
      var customer = customerRepo.save(customerRequestMapper.toEntity(request));
      return customerResponseMapper.toDto(customer);
    }

    public void updateCustomer(CustomerRequest request){
        var customer = customerRepo.findById(request.getId())
                .orElseThrow(() -> new CustomerNotFoundByIdException(
                        String.format("Невозможно обновить данные покупателя:: покупатель с ID : %s не найден", request.getId())
                ));
        mergeCustomer(customer, request);
        customerRepo.save(customer);
    }

    public List<CustomerResponse> findAll() {
        return customerResponseMapper.toDto(customerRepo.findAll());
    }
    public String existsById(String customerId) {
        if(customerRepo.findById(customerId).isPresent()) {
            return String.format("Покупатель с ID : %s существует.", customerId);
        } else {
            return String.format("Покупателя с ID : %s не существует", customerId);
        }
    }
    public CustomerResponse getCustomerById(String customerId) {
        var customer = customerRepo.findById(customerId).orElseThrow(
                ()->new CustomerNotFoundByIdException(String.format("Невозможно получить данные о покупателе:: покупатель с ID : %s не найден", customerId))
        );

        return customerResponseMapper.toDto(customer);
    }
    public void deleteCustomerById(String customerId) {
        customerRepo.deleteById(customerId);
    }
    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.getFirstName())) {
            customer.setFirstName(request.getFirstName());
        }

        if(StringUtils.isNotBlank(request.getLastName())) {
            customer.setLastName(request.getLastName());
        }

        if(StringUtils.isNotBlank(request.getEmail())) {
            customer.setEmail(request.getEmail());
        }

        if(request.getAddress()!=null) {
            customer.setAddress(request.getAddress());
        }
    }

}
