package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> findAll();

    Provider findById(Long id);

    Provider save(Provider provider);

    Provider update(Provider provider);

    void delete(Provider provider);

    void deleteById(Long id);

}
