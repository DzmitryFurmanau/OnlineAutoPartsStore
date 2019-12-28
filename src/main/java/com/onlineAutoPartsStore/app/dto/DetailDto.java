package com.onlineAutoPartsStore.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DetailDto {

    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{detail.name.notNull}")
    @NotEmpty(message = "{detail.name.notEmpty}")
    private String name;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{detail.type.notNull}")
    @NotEmpty(message = "{detail.type.notEmpty}")
    private String type;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{detail.price.notNull}")
    @NotEmpty(message = "{detail.price.notEmpty}")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
