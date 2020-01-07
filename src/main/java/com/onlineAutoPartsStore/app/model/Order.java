package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Order.
 */
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

    /**
     * Instantiates a new Order.
     */
    public Order() {
    }

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
    public Seller getSeller() {
        return seller;
    }

    /**
     * Sets seller.
     *
     * @param seller the seller
     */
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * Gets details stocks.
     *
     * @return the details stocks
     */
    public DetailsStocks getDetailsStocks() {
        return detailsStocks;
    }

    /**
     * Sets details stocks.
     *
     * @param detailsStocks the details stocks
     */
    public void setDetailsStocks(DetailsStocks detailsStocks) {
        this.detailsStocks = detailsStocks;
    }

    /**
     * Gets customers addresses.
     *
     * @return the customers addresses
     */
    public CustomersAddresses getCustomersAddresses() {
        return customersAddresses;
    }

    /**
     * Sets customers addresses.
     *
     * @param customersAddresses the customers addresses
     */
    public void setCustomersAddresses(CustomersAddresses customersAddresses) {
        this.customersAddresses = customersAddresses;
    }
}