package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.HeaverDto;
import com.onlineAutoPartsStore.app.dto.ProviderDto;

public class StockResponseDto {

    private Long id;

    private Integer quantity;

    private ProviderDto provider;

    private HeaverDto heaver;

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

    public ProviderDto getProvider() {
        return provider;
    }

    public void setProvider(ProviderDto provider) {
        this.provider = provider;
    }

    public HeaverDto getHeaver() {
        return heaver;
    }

    public void setHeaver(HeaverDto heaver) {
        this.heaver = heaver;
    }
}
