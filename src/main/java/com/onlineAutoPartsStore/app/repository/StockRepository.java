package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

    boolean existsByQuantity(Integer quantity);

    Stock findByQuantity(Integer quantity);
}
