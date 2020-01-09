package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.CustomerRequestDto;
import com.onlineAutoPartsStore.app.dto.response.CustomerResponseDto;
import com.onlineAutoPartsStore.app.model.Customer;
import com.onlineAutoPartsStore.app.service.CustomerService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Mapper mapper;

    private final CustomerService customerService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Customer controller.
     *
     * @param mapper                 the mapper
     * @param customerService        the customer service
     * @param localizedMessageSource the localized message source
     */
    public CustomerController(Mapper mapper, CustomerService customerService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.customerService = customerService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll() {
        final List<Customer> customers = customerService.findAll();
        final List<CustomerResponseDto> customerResponseDtoList = customers.stream()
                .map((customer) -> mapper.map(customer, CustomerResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(customerResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponseDto> getOne(@PathVariable Long id) {
        final CustomerResponseDto customerResponseDto = mapper.map(customerService.findById(id), CustomerResponseDto.class);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param customerRequestDto the customer request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<CustomerResponseDto> save(@RequestBody CustomerRequestDto customerRequestDto) {
        customerRequestDto.setId(null);
        final CustomerResponseDto customerResponseDto = mapper.map(customerService.save(mapper.map(customerRequestDto, Customer.class)), CustomerResponseDto.class);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param customerRequestDto the customer request dto
     * @param id                 the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerResponseDto> update(@RequestBody CustomerRequestDto customerRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, customerRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.customer.unexpectedId", new Object[]{}));
        }
        final CustomerResponseDto customerResponseDto = mapper.map(customerService.update(mapper.map(customerRequestDto, Customer.class)), CustomerResponseDto.class);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}
