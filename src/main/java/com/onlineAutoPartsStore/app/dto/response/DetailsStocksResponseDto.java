package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.DetailDto;
import com.onlineAutoPartsStore.app.dto.StockDto;

/**
 * The type Details stocks response dto.
 */
public class DetailsStocksResponseDto {

    private Long id;

    private DetailDto detail;

    private StockDto stock;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets detail.
     *
     * @return the detail
     */
    public DetailDto getDetail() {
        return detail;
    }

    /**
     * Sets detail.
     *
     * @param detail the detail
     */
    public void setDetail(DetailDto detail) {
        this.detail = detail;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public StockDto getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(StockDto stock) {
        this.stock = stock;
    }
}
