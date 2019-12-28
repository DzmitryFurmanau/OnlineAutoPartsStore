package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.CarDto;

public class DetailResponseDto {

    private Long id;

    private String name;

    private String type;

    private Double price;

    private CarDto car;

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

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }
}
