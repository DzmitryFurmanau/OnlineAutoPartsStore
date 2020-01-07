package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Exists by date boolean.
     *
     * @param date the date
     * @return the boolean
     */
    boolean existsByDate(String date);

    /**
     * Find by date order.
     *
     * @param date the date
     * @return the order
     */
    Order findByDate(String date);
}
