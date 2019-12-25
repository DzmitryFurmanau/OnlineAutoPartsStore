package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.CustomersAddresses;

import java.util.List;

public interface CustomersAddressesService {

    List<CustomersAddresses> findAll();

    CustomersAddresses findById(Long id);

    CustomersAddresses save(CustomersAddresses customersAddresses);

    CustomersAddresses update(CustomersAddresses customersAddresses);

    void delete(CustomersAddresses customersAddresses);

    void deleteById(Long id);

}
