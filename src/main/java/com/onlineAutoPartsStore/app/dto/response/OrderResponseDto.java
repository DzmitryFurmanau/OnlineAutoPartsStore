package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.CustomersAddressesDto;
import com.onlineAutoPartsStore.app.dto.DetailsStocksDto;
import com.onlineAutoPartsStore.app.dto.SellerDto;

public class OrderResponseDto {

    private Long id;

    private String date;

    private Integer sum;

    private SellerDto seller;

    private DetailsStocksDto detailsStocks;

    private CustomersAddressesDto customersAddresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public SellerDto getSeller() {
        return seller;
    }

    public void setSeller(SellerDto seller) {
        this.seller = seller;
    }

    public DetailsStocksDto getDetailsStocks() {
        return detailsStocks;
    }

    public void setDetailsStocks(DetailsStocksDto detailsStocks) {
        this.detailsStocks = detailsStocks;
    }

    public CustomersAddressesDto getCustomersAddresses() {
        return customersAddresses;
    }

    public void setCustomersAddresses(CustomersAddressesDto customersAddresses) {
        this.customersAddresses = customersAddresses;
    }
}
