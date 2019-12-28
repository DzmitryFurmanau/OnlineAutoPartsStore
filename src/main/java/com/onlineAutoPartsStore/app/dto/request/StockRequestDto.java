package com.onlineAutoPartsStore.app.dto.request;

public class StockRequestDto {

    private Long id;

    private Integer quantity;

    private Long providerId;

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
