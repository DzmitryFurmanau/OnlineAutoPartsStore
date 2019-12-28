package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "car", schema = "public")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{car.model.notNull}")
    @NotEmpty(message = "{car.model.notEmpty}")
    private String model;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{car.year.notNull}")
    @NotEmpty(message = "{car.year.notEmpty}")
    private Short year;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{car.pinCode.notNull}")
    @NotEmpty(message = "{car.pinCode.notEmpty}")
    private String pinCode;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}