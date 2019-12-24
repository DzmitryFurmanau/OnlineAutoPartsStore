package com.onlineAutoPartsStore.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerDto {

    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{customer.name.notNull}")
    @NotEmpty(message = "{customer.name.notEmpty}")
    private String name;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{customer.password.notNull}")
    @NotEmpty(message = "{customer.password.notEmpty}")
    private String password;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{customer.email.notNull}")
    @NotEmpty(message = "{customer.email.notEmpty}")
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}