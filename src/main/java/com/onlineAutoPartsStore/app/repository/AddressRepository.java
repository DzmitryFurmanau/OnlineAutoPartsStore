package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    boolean existsByPhoneNumber(Integer phoneNumber);

    Address findByPhoneNumber(Integer phoneNumber);
}
