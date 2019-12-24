package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    Customer update(Customer customer);

    void delete(Customer customer);

    void deleteById(Long id);

}
