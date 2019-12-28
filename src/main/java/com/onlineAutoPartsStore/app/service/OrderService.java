package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);

    Order update(Order order);

    void delete(Order order);

    void deleteById(Long id);
}
