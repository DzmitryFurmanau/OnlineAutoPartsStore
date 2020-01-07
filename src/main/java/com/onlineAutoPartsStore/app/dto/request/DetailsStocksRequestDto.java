package com.onlineAutoPartsStore.app.dto.request;

/**
 * The type Details stocks request dto.
 */
public class DetailsStocksRequestDto {

    private Long id;

    private Long stockId;

    private Long detailId;

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
     * Gets stock id.
     *
     * @return the stock id
     */
    public Long getStockId() {
        return stockId;
    }

    /**
     * Sets stock id.
     *
     * @param stockId the stock id
     */
    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    /**
     * Gets detail id.
     *
     * @return the detail id
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * Sets detail id.
     *
     * @param detailId the detail id
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
}
