package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers_addresses", schema = "public")
public class CustomersAddresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    @NotNull(message = "{customers_addresses.address.notNull}")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull(message = "{customers_addresses.customer.notNull}")
    private Customer customer;

    public CustomersAddresses() {

    }

    public CustomersAddresses(Long id, Address address, Customer customer) {
        this.id = id;
        this.address = address;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}