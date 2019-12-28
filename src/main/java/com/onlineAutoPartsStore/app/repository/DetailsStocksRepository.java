package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.DetailsStocks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailsStocksRepository extends JpaRepository<DetailsStocks, Long> {

    boolean existsById(Long id);

    Optional<DetailsStocks> findById(Long id);
}