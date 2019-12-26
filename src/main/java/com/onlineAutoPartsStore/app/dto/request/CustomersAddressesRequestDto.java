package com.onlineAutoPartsStore.app.dto.request;

import javax.validation.constraints.NotNull;

public class CustomersAddressesRequestDto {

    private Long id;

    @NotNull(message = "{customers_addresses.address.notNull}")
    private Long addressId;

    @NotNull(message = "{customers_addresses.customer.notNull}")
    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
