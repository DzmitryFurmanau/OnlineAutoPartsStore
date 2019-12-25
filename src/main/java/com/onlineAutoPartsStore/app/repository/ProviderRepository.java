package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    boolean existsByName(String name);

    Provider findByName(String name);
}
