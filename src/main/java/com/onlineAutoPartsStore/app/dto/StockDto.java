package com.onlineAutoPartsStore.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StockDto {

    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{stock.quantity.notNull}")
    @NotEmpty(message = "{stock.quantity.notEmpty}")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}