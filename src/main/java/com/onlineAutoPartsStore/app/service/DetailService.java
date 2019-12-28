package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.Detail;

import java.util.List;

public interface DetailService {

    List<Detail> findAll();

    Detail findById(Long id);

    Detail save(Detail detail);

    Detail update(Detail detail);

    void delete(Detail detail);

    void deleteById(Long id);

}
