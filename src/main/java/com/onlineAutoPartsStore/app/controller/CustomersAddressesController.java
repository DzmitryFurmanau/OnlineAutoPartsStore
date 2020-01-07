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

/**
 * The type Customers addresses controller.
 */
@RestController
@RequestMapping("/customers_addresses")
public class CustomersAddressesController {

    private final Mapper mapper;

    private final CustomersAddressesService customersAddressesService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Customers addresses controller.
     *
     * @param mapper                    the mapper
     * @param customersAddressesService the customers addresses service
     * @param localizedMessageSource    the localized message source
     */
    public CustomersAddressesController(Mapper mapper, CustomersAddressesService customersAddressesService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.customersAddressesService = customersAddressesService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<CustomersAddressesResponseDto>> getAll() {
        final List<CustomersAddresses> customersAddresses = customersAddressesService.findAll();
        final List<CustomersAddressesResponseDto> customersAddressesResponseDtoList = customersAddresses.stream()
                .map((customerAddresses) -> mapper.map(customerAddresses, CustomersAddressesResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(customersAddressesResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomersAddressesResponseDto> getOne(@PathVariable Long id) {
        final CustomersAddressesResponseDto customersAddressesResponseDto = mapper.map(customersAddressesService.findById(id), CustomersAddressesResponseDto.class);
        return new ResponseEntity<>(customersAddressesResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param customersAddressesRequestDto the customers addresses request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<CustomersAddressesResponseDto> save(@RequestBody CustomersAddressesRequestDto customersAddressesRequestDto) {
        customersAddressesRequestDto.setId(null);
        final CustomersAddressesResponseDto CustomersAddressesResponseDto = mapper.map(customersAddressesService.save(getCustomersAddresses(customersAddressesRequestDto)), CustomersAddressesResponseDto.class);
        return new ResponseEntity<>(CustomersAddressesResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param customersAddressesRequestDto the customers addresses request dto
     * @param id                           the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomersAddressesResponseDto> update(@RequestBody CustomersAddressesRequestDto customersAddressesRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, customersAddressesRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.customers_addresses.unexpectedId", new Object[]{}));
        }
        final CustomersAddressesResponseDto customersAddressesResponseDto = mapper.map(customersAddressesService.update(getCustomersAddresses(customersAddressesRequestDto)), CustomersAddressesResponseDto.class);
        return new ResponseEntity<>(customersAddressesResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        customersAddressesService.deleteById(id);
    }

    private CustomersAddresses getCustomersAddresses(CustomersAddressesRequestDto customersAddressesRequestDto) {
        final CustomersAddresses customersAddresses = mapper.map(customersAddressesRequestDto, CustomersAddresses.class);
        final Customer customer = new Customer();
        final Address address = new Address();
        customer.setId(customersAddressesRequestDto.getCustomerId());
        address.setId(customersAddressesRequestDto.getAddressId());
        customersAddresses.setCustomer(customer);
        customersAddresses.setAddress(address);
        return customersAddresses;
    }
}
