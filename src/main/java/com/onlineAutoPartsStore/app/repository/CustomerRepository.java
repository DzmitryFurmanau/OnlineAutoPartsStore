package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByName(String name);

    Customer findByName(String name);
}
