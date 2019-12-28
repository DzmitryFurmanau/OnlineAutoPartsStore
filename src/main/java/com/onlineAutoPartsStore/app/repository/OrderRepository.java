package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    boolean existsByDate(String date);

    Order findByDate(String date);
}
