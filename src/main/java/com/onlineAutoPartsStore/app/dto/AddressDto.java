package com.onlineAutoPartsStore.app.dto;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressDto {

    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.phoneNumber.notNull}")
    @NotEmpty(message = "{address.phoneNumber.notEmpty}")
    private Integer phoneNumber;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.street.notNull}")
    @NotEmpty(message = "{address.street.notEmpty}")
    private String street;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.city.notNull}")
    @NotEmpty(message = "{address.city.notEmpty}")
    private String city;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.state.notNull}")
    @NotEmpty(message = "{address.state.notEmpty}")
    private String state;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.country.notNull}")
    @NotEmpty(message = "{address.country.notEmpty}")
    private String country;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.pinCode.notNull}")
    @NotEmpty(message = "{address.pinCode.notEmpty}")
    private Integer pinCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}
