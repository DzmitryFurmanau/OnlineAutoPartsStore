package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT u FROM Customer u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%',:name))")
    List<Customer> findByNameStartsWithParam(@Param("name") String name);

    boolean existsByName(String name);

    Customer findByName(String name);
}
