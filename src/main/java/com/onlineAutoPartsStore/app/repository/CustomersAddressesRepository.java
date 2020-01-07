package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.CustomersAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Customers addresses repository.
 */
public interface CustomersAddressesRepository extends JpaRepository<CustomersAddresses, Long> {

    boolean existsById(Long id);

    Optional<CustomersAddresses> findById(Long id);
}
