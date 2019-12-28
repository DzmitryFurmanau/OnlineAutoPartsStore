package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.CustomersAddressesRequestDto;
import com.onlineAutoPartsStore.app.dto.response.CustomersAddressesResponseDto;
import com.onlineAutoPartsStore.app.model.Address;
import com.onlineAutoPartsStore.app.model.Customer;
import com.onlineAutoPartsStore.app.model.CustomersAddresses;
import com.onlineAutoPartsStore.app.service.CustomersAddressesService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers_addresses")
public class CustomersAddressesController {

    private final Mapper mapper;

    private final CustomersAddressesService customersAddressesService;

    private final LocalizedMessageSource localizedMessageSource;

    public CustomersAddressesController(Mapper mapper, CustomersAddressesService customersAddressesService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.customersAddressesService = customersAddressesService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @GetMapping
    public ResponseEntity<List<CustomersAddressesResponseDto>> getAll() {
        final List<CustomersAddresses> customersAddresses = customersAddressesService.findAll();
        final List<CustomersAddressesResponseDto> customersAddressesResponseDtoList = customersAddresses.stream()
                .map((customerAddresses) -> mapper.map(customerAddresses, CustomersAddressesResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(customersAddressesResponseDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomersAddressesResponseDto> getOne(@PathVariable Long id) {
        final CustomersAddressesResponseDto customersAddressesResponseDto = mapper.map(customersAddressesService.findById(id), CustomersAddressesResponseDto.class);
        return new ResponseEntity<>(customersAddressesResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomersAddressesResponseDto> save(@RequestBody CustomersAddressesRequestDto customersAddressesRequestDto) {
        customersAddressesRequestDto.setId(null);
        final CustomersAddressesResponseDto CustomersAddressesResponseDto = mapper.map(customersAddressesService.save(getCustomersAddresses(customersAddressesRequestDto)), CustomersAddressesResponseDto.class);
        return new ResponseEntity<>(CustomersAddressesResponseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomersAddressesResponseDto> update(@RequestBody CustomersAddressesRequestDto customersAddressesRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, customersAddressesRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.customers_addresses.unexpectedId", new Object[]{}));
        }
        final CustomersAddressesResponseDto customersAddressesResponseDto = mapper.map(customersAddressesService.update(getCustomersAddresses(customersAddressesRequestDto)), CustomersAddressesResponseDto.class);
        return new ResponseEntity<>(customersAddressesResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        customersAddressesService.deleteById(id);
    }

    private CustomersAddresses getCustomersAddresses(CustomersAddressesRequestDto customersAddressesRequestDto) {
        final CustomersAddresses customersAddresses = mapper.map(customersAddressesRequestDto, CustomersAddresses.class);
        final Address address = new Address();
        final Customer customer = new Customer();
        address.setId(customersAddressesRequestDto.getAddressId());
        customer.setId(customersAddressesRequestDto.getCustomerId());
        customersAddresses.setAddress(address);
        customersAddresses.setCustomer(customer);
        return customersAddresses;
    }
}
