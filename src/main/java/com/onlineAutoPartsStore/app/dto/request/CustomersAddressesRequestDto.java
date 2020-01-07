package com.onlineAutoPartsStore.app.dto.request;

/**
 * The type Customers addresses request dto.
 */
public class CustomersAddressesRequestDto {

    private Long id;

    private Long customerId;

    private Long addressId;

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
     * Gets customer id.
     *
     * @return the customer id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets address id.
     *
     * @return the address id
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * Sets address id.
     *
     * @param addressId the address id
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
