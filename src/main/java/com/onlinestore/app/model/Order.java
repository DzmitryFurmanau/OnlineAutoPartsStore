package com.onlinestore.app.model;

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
    @JoinColumn(name = "detail_id", nullable = false)
    @NotNull(message = "{order.detail.notNull}")
    private Detail detail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id", nullable = false)
    @NotNull(message = "{order.stock.notNull}")
    private Stock stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull(message = "{order.customer.notNull}")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    @NotNull(message = "{order.address.notNull}")
    private Address address;

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
    public Detail getDetail() {
        return detail;
    }

    /**
     * Sets detail.
     *
     * @param detail the detail
     */
    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}