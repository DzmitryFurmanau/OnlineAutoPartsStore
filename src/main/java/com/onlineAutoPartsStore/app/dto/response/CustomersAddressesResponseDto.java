package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.AddressDto;
import com.onlineAutoPartsStore.app.dto.CustomerDto;

/**
 * The type Customers addresses response dto.
 */
public class CustomersAddressesResponseDto {

    private Long id;

    private CustomerDto customer;

    private AddressDto address;

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
     * Gets customer.
     *
     * @return the customer
     */
    public CustomerDto getCustomer() {
        return customer;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public AddressDto getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
