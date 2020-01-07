package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.CustomersAddressesDto;
import com.onlineAutoPartsStore.app.dto.DetailsStocksDto;
import com.onlineAutoPartsStore.app.dto.SellerDto;

/**
 * The type Order response dto.
 */
public class OrderResponseDto {

    private Long id;

    private String date;

    private Integer sum;

    private SellerDto seller;

    private DetailsStocksDto detailsStocks;

    private CustomersAddressesDto customersAddresses;

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
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets sum.
     *
     * @return the sum
     */
    public Integer getSum() {
        return sum;
    }

    /**
     * Sets sum.
     *
     * @param sum the sum
     */
    public void setSum(Integer sum) {
        this.sum = sum;
    }

    /**
     * Gets seller.
     *
     * @return the seller
     */
    public SellerDto getSeller() {
        return seller;
    }

    /**
     * Sets seller.
     *
     * @param seller the seller
     */
    public void setSeller(SellerDto seller) {
        this.seller = seller;
    }

    /**
     * Gets details stocks.
     *
     * @return the details stocks
     */
    public DetailsStocksDto getDetailsStocks() {
        return detailsStocks;
    }

    /**
     * Sets details stocks.
     *
     * @param detailsStocks the details stocks
     */
    public void setDetailsStocks(DetailsStocksDto detailsStocks) {
        this.detailsStocks = detailsStocks;
    }

    /**
     * Gets customers addresses.
     *
     * @return the customers addresses
     */
    public CustomersAddressesDto getCustomersAddresses() {
        return customersAddresses;
    }

    /**
     * Sets customers addresses.
     *
     * @param customersAddresses the customers addresses
     */
    public void setCustomersAddresses(CustomersAddressesDto customersAddresses) {
        this.customersAddresses = customersAddresses;
    }
}
