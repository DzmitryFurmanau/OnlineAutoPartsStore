package com.onlineAutoPartsStore.app.service.impl;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.model.Car;
import com.onlineAutoPartsStore.app.repository.CarRepository;
import com.onlineAutoPartsStore.app.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final LocalizedMessageSource localizedMessageSource;

    public CarServiceImpl(CarRepository carRepository, LocalizedMessageSource localizedMessageSource) {
        this.carRepository = carRepository;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource.getMessage("error.car.notExist", new Object[]{})));
    }

    @Override
    public Car save(Car car) {
        validate(car.getId() != null, localizedMessageSource.getMessage("error.car.notHaveId", new Object[]{}));
        validate(carRepository.existsByModel(car.getModel()), localizedMessageSource.getMessage("error.car.model.notUnique", new Object[]{}));
        return carRepository.saveAndFlush(car);
    }

    @Override
    public Car update(Car car) {
        final Long id = car.getId();
        validate(id == null, localizedMessageSource.getMessage("error.car.haveId", new Object[]{}));
        final Car duplicateCar = carRepository.findByModel(car.getModel());
        final boolean isDuplicateExists = duplicateCar != null && !Objects.equals(duplicateCar.getId(), id);
        validate(isDuplicateExists, localizedMessageSource.getMessage("error.car.model.notUnique", new Object[]{}));
        findById(id);
        return carRepository.saveAndFlush(car);
    }


    @Override
    public void delete(Car car) {
        final Long id = car.getId();
        validate(id == null, localizedMessageSource.getMessage("error.car.haveId", new Object[]{}));
        findById(id);
        carRepository.delete(car);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        carRepository.deleteById(id);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}