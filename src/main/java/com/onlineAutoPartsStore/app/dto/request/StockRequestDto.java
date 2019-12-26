package com.onlineAutoPartsStore.app.dto.request;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StockRequestDto {

    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{stock.quantity.notNull}")
    @NotEmpty(message = "{stock.quantity.notEmpty}")
    private Integer quantity;

    @NotNull(message = "{stock.provider.notNull}")
    private Long providerId;

    @NotNull(message = "{stock.heaver.notNull}")
    private Long heaverId;

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

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getHeaverId() {
        return heaverId;
    }

    public void setHeaverId(Long heaverId) {
        this.heaverId = heaverId;
    }
}
