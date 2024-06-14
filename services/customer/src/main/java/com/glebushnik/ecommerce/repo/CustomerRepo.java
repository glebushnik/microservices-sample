package com.glebushnik.ecommerce.repo;

import com.glebushnik.ecommerce.domain.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer, String> {
}
