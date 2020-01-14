package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * The type Customer.
 */
@Entity
@Table(name = "customers", schema = "public")
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customers_addresses",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    @NotNull(message = "{customer.addresses.notNull}")
    private Set<Address> addresses;

    /**
     * Instantiates a new Customer.
     */
    public Customer() {
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public Set<Address> getAddresses() {
        return addresses;
    }

    /**
     * Sets addresses.
     *
     * @param addresses the addresses
     */
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}