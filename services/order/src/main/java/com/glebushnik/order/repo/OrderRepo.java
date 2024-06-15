package com.glebushnik.order.repo;

import com.glebushnik.order.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrderRepo extends JpaRepository<Order, Long> {
}
