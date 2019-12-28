package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    boolean existsByModel(String model);

    Car findByModel(String model);
}
