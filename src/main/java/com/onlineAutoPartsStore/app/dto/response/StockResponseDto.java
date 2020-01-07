package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.HeaverDto;
import com.onlineAutoPartsStore.app.dto.ProviderDto;

/**
 * The type Stock response dto.
 */
public class StockResponseDto {

    private Long id;

    private Integer quantity;

    private ProviderDto provider;

    private HeaverDto heaver;

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
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets provider.
     *
     * @return the provider
     */
    public ProviderDto getProvider() {
        return provider;
    }

    /**
     * Sets provider.
     *
     * @param provider the provider
     */
    public void setProvider(ProviderDto provider) {
        this.provider = provider;
    }

    /**
     * Gets heaver.
     *
     * @return the heaver
     */
    public HeaverDto getHeaver() {
        return heaver;
    }

    /**
     * Sets heaver.
     *
     * @param heaver the heaver
     */
    public void setHeaver(HeaverDto heaver) {
        this.heaver = heaver;
    }
}
