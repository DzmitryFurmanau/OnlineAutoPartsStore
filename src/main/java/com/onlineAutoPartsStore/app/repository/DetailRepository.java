package com.onlineAutoPartsStore.app.repository;

import com.onlineAutoPartsStore.app.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, Long> {

    boolean existsByName(String name);

    Detail findByName(String name);
}
