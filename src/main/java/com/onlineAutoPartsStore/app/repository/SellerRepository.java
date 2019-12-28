package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    boolean existsByName(String name);

    Seller findByName(String name);
}
