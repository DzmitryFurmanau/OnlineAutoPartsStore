package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer", schema = "public")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    @NotNull(message = "{customer.address.notNull}")
    private Address address;

    public Customer() {

    }

    public Customer(Long id, String name, String password, String email, Address address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}