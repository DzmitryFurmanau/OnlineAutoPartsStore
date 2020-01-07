package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.DetailsStocks;

import java.util.List;

/**
 * The interface Details stocks service.
 */
public interface DetailsStocksService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<DetailsStocks> findAll();

    /**
     * Find by id details stocks.
     *
     * @param id the id
     * @return the details stocks
     */
    DetailsStocks findById(Long id);

    /**
     * Save details stocks.
     *
     * @param detailsStocks the details stocks
     * @return the details stocks
     */
    DetailsStocks save(DetailsStocks detailsStocks);

    /**
     * Update details stocks.
     *
     * @param detailsStocks the details stocks
     * @return the details stocks
     */
    DetailsStocks update(DetailsStocks detailsStocks);

    /**
     * Delete.
     *
     * @param detailsStocks the details stocks
     */
    void delete(DetailsStocks detailsStocks);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
