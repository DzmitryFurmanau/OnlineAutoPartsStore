package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.DetailsStocks;

import java.util.List;

public interface DetailsStocksService {

    List<DetailsStocks> findAll();

    DetailsStocks findById(Long id);

    DetailsStocks save(DetailsStocks detailsStocks);

    DetailsStocks update(DetailsStocks detailsStocks);

    void delete(DetailsStocks detailsStocks);

    void deleteById(Long id);

}
