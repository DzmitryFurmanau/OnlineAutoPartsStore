package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.CustomersAddresses;

import java.util.List;

/**
 * The interface Customers addresses service.
 */
public interface CustomersAddressesService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<CustomersAddresses> findAll();

    /**
     * Find by id customers addresses.
     *
     * @param id the id
     * @return the customers addresses
     */
    CustomersAddresses findById(Long id);

    /**
     * Save customers addresses.
     *
     * @param customersAddresses the customers addresses
     * @return the customers addresses
     */
    CustomersAddresses save(CustomersAddresses customersAddresses);

    /**
     * Update customers addresses.
     *
     * @param customersAddresses the customers addresses
     * @return the customers addresses
     */
    CustomersAddresses update(CustomersAddresses customersAddresses);

    /**
     * Delete.
     *
     * @param customersAddresses the customers addresses
     */
    void delete(CustomersAddresses customersAddresses);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
