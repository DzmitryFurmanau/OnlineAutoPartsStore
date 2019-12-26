package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.Stock;

import java.util.List;

public interface StockService {

    List<Stock> findAll();

    Stock findById(Long id);

    Stock save(Stock stock);

    Stock update(Stock stock);

    void delete(Stock stock);

    void deleteById(Long id);

}
