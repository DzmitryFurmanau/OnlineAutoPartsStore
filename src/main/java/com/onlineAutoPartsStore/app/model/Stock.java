package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stock", schema = "public")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{stock.quantity.notNull}")
    @NotEmpty(message = "{stock.quantity.notEmpty}")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    @NotNull(message = "{stock.provider.notNull}")
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "heaver_id", nullable = false)
    @NotNull(message = "{stock.heaver.notNull}")
    private Heaver heaver;

    public Stock() {

    }

    public Stock(Long id, Integer quantity, Provider provider, Heaver heaver) {
        this.id = id;
        this.quantity = quantity;
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Heaver getHeaver() {
        return heaver;
    }

    public void setHeaver(Heaver heaver) {
        this.heaver = heaver;
    }
}