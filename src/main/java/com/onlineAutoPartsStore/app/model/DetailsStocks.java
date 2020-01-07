package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * The type Details stocks.
 */
@Entity
@Table(name = "details_stocks", schema = "public")
public class DetailsStocks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "detail_id", nullable = false)
    @NotNull(message = "{details_stocks.detail.notNull}")
    private Detail detail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id", nullable = false)
    @NotNull(message = "{details_stocks.stock.notNull}")
    private Stock stock;

    /**
     * Instantiates a new Details stocks.
     */
    public DetailsStocks() {
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
     * Gets detail.
     *
     * @return the detail
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
}