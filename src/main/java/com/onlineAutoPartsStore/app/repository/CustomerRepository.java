package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Find by name starts with param list.
     *
     * @param name the name
     * @return the list
     */
    @Query(value = "SELECT u FROM Customer u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%',:name))")
    List<Customer> findByNameStartsWithParam(@Param("name") String name);

    /**
     * Exists by name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByName(String name);

    /**
     * Find by name customer.
     *
     * @param name the name
     * @return the customer
     */
    Customer findByName(String name);
}
