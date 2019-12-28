package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.DetailDto;
import com.onlineAutoPartsStore.app.dto.StockDto;

public class DetailsStocksResponseDto {

    private Long id;

    private DetailDto detail;

    private StockDto stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DetailDto getDetail() {
        return detail;
    }

    public void setDetail(DetailDto detail) {
        this.detail = detail;
    }

    public StockDto getStock() {
        return stock;
    }

    public void setStock(StockDto stock) {
        this.stock = stock;
    }
}
