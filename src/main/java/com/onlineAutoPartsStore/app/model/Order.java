package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{order.date.notNull}")
    @NotEmpty(message = "{order.date.notEmpty}")
    private String date;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{order.sum.notNull}")
    @NotEmpty(message = "{order.sum.notEmpty}")
    private Integer sum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id", nullable = false)
    @NotNull(message = "{order.seller.notNull}")
    private Seller seller;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "details_stocks_id", nullable = false)
    @NotNull(message = "{order.details_stocks.notNull}")
    private DetailsStocks detailsStocks;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customers_addresses_id", nullable = false)
    @NotNull(message = "{order.customers_addresses.notNull}")
    private CustomersAddresses customersAddresses;

    public Order() {
    }

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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public DetailsStocks getDetailsStocks() {
        return detailsStocks;
    }

    public void setDetailsStocks(DetailsStocks detailsStocks) {
        this.detailsStocks = detailsStocks;
    }

    public CustomersAddresses getCustomersAddresses() {
        return customersAddresses;
    }

    public void setCustomersAddresses(CustomersAddresses customersAddresses) {
        this.customersAddresses = customersAddresses;
    }
}