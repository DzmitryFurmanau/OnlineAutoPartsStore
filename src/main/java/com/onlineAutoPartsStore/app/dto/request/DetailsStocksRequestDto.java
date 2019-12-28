package com.onlineAutoPartsStore.app.dto.request;

import javax.validation.constraints.NotNull;

public class DetailsStocksRequestDto {

    private Long id;

    @NotNull(message = "{details_stocks.stock.notNull}")
    private Long stockId;

    @NotNull(message = "{details_stocks.detail.notNull}")
    private Long detailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
}
