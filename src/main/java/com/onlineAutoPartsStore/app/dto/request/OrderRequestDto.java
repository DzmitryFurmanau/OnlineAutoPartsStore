package com.onlineAutoPartsStore.app.dto.request;

public class OrderRequestDto {

    private Long id;

    private String date;

    private Integer sum;

    private Long sellerId;

    private Long detailsStocksId;

    private Long customersAddressesId;

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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getDetailsStocksId() {
        return detailsStocksId;
    }

    public void setDetailsStocksId(Long detailsStocksId) {
        this.detailsStocksId = detailsStocksId;
    }

    public Long getCustomersAddressesId() {
        return customersAddressesId;
    }

    public void setCustomersAddressesId(Long customersAddressesId) {
        this.customersAddressesId = customersAddressesId;
    }
}
