package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.AddressRequestDto;
import com.onlineAutoPartsStore.app.dto.response.AddressResponseDto;
import com.onlineAutoPartsStore.app.model.Address;
import com.onlineAutoPartsStore.app.service.AddressService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Address controller.
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    private final Mapper mapper;

    private final AddressService addressService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Address controller.
     *
     * @param mapper                 the mapper
     * @param addressService         the address service
     * @param localizedMessageSource the localized message source
     */
    public AddressController(Mapper mapper, AddressService addressService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.addressService = addressService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<AddressResponseDto>> getAll() {
        final List<Address> addresses = addressService.findAll();
        final List<AddressResponseDto> addressResponseDtoList = addresses.stream()
                .map((address) -> mapper.map(address, AddressResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(addressResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressResponseDto> getOne(@PathVariable Long id) {
        final AddressResponseDto addressResponseDto = mapper.map(addressService.findById(id), AddressResponseDto.class);
        return new ResponseEntity<>(addressResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param addressRequestDto the address request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<AddressResponseDto> save(@RequestBody AddressRequestDto addressRequestDto) {
        addressRequestDto.setId(null);
        final AddressResponseDto addressResponseDto = mapper.map(addressService.save(mapper.map(addressRequestDto, Address.class)), AddressResponseDto.class);
        return new ResponseEntity<>(addressResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param addressRequestDto the address request dto
     * @param id                the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressResponseDto> update(@RequestBody AddressRequestDto addressRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, addressRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.address.unexpectedId", new Object[]{}));
        }
        final AddressResponseDto addressResponseDto = mapper.map(addressService.update(mapper.map(addressRequestDto, Address.class)), AddressResponseDto.class);
        return new ResponseEntity<>(addressResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        addressService.deleteById(id);
    }
}
