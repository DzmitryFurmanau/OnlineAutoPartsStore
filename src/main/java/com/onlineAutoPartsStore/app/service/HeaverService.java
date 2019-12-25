package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.Heaver;

import java.util.List;

public interface HeaverService {

    List<Heaver> findAll();

    Heaver findById(Long id);

    Heaver save(Heaver heaver);

    Heaver update(Heaver heaver);

    void delete(Heaver heaver);

    void deleteById(Long id);

}
