package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.CarRequestDto;
import com.onlineAutoPartsStore.app.dto.response.CarResponseDto;
import com.onlineAutoPartsStore.app.model.Car;
import com.onlineAutoPartsStore.app.service.CarService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {

    private final Mapper mapper;

    private final CarService carService;

    private final LocalizedMessageSource localizedMessageSource;

    public CarController(Mapper mapper, CarService carService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.carService = carService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAll() {
        final List<Car> cars = carService.findAll();
        final List<CarResponseDto> carResponseDtoList = cars.stream()
                .map((car) -> mapper.map(car, CarResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(carResponseDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarResponseDto> getOne(@PathVariable Long id) {
        final CarResponseDto carResponseDto = mapper.map(carService.findById(id), CarResponseDto.class);
        return new ResponseEntity<>(carResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarResponseDto> save(@RequestBody CarRequestDto carRequestDto) {
        carRequestDto.setId(null);
        final CarResponseDto carResponseDto = mapper.map(carService.save(mapper.map(carRequestDto, Car.class)), CarResponseDto.class);
        return new ResponseEntity<>(carResponseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CarResponseDto> update(@RequestBody CarRequestDto carRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, carRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.car.unexpectedId", new Object[]{}));
        }
        final CarResponseDto carResponseDto = mapper.map(carService.update(mapper.map(carRequestDto, Car.class)), CarResponseDto.class);
        return new ResponseEntity<>(carResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
