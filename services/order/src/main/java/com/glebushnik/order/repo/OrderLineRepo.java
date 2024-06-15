package com.glebushnik.order.repo;

import com.glebushnik.order.domain.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderLineRepo extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findAllByOrderId(Long orderId);
}
