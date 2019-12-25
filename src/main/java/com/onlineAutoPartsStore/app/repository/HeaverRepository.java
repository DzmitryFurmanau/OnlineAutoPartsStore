package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Heaver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaverRepository extends JpaRepository<Heaver, Long> {

    boolean existsByName(String name);

    Heaver findByName(String name);
}
