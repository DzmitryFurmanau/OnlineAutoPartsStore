package com.onlineAutoPartsStore.app.dto.request;

/**
 * The type Order request dto.
 */
public class OrderRequestDto {

    private Long id;

    private String date;

    private Integer sum;

    private Long sellerId;

    private Long detailsStocksId;

    private Long customersAddressesId;

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
     * Gets seller id.
     *
     * @return the seller id
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * Sets seller id.
     *
     * @param sellerId the seller id
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * Gets details stocks id.
     *
     * @return the details stocks id
     */
    public Long getDetailsStocksId() {
        return detailsStocksId;
    }

    /**
     * Sets details stocks id.
     *
     * @param detailsStocksId the details stocks id
     */
    public void setDetailsStocksId(Long detailsStocksId) {
        this.detailsStocksId = detailsStocksId;
    }

    /**
     * Gets customers addresses id.
     *
     * @return the customers addresses id
     */
    public Long getCustomersAddressesId() {
        return customersAddressesId;
    }

    /**
     * Sets customers addresses id.
     *
     * @param customersAddressesId the customers addresses id
     */
    public void setCustomersAddressesId(Long customersAddressesId) {
        this.customersAddressesId = customersAddressesId;
    }
}
