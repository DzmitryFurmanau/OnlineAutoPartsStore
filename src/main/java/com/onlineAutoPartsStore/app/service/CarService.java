package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(Long id);

    Car save(Car car);

    Car update(Car car);

    void delete(Car car);

    void deleteById(Long id);

}
