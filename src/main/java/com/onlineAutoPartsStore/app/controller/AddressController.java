package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.AddressDto;
import com.onlineAutoPartsStore.app.model.Address;
import com.onlineAutoPartsStore.app.service.AddressService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final Mapper mapper;

    private final AddressService addressService;

    private final LocalizedMessageSource localizedMessageSource;

    public AddressController(Mapper mapper, AddressService addressService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.addressService = addressService;
        this.localizedMessageSource = localizedMessageSource;
    }


    @GetMapping
    public ResponseEntity<List<AddressDto>> getAll() {
        final List<Address> addresses = addressService.findAll();
        final List<AddressDto> addressDtoList = addresses.stream()
                .map((role) -> mapper.map(role, AddressDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(addressDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto> getOne(@PathVariable Long id) {
        final AddressDto addressDto = mapper.map(addressService.findById(id), AddressDto.class);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDto> save(@RequestBody AddressDto addressDto) {
        addressDto.setId(null);
        final AddressDto responseAddressDto = mapper.map(addressService.save(mapper.map(addressDto, Address.class)), AddressDto.class);
        return new ResponseEntity<>(responseAddressDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressDto> update(@RequestBody AddressDto addressDto, @PathVariable Long id) {
        if (!Objects.equals(id, addressDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.address.unexpectedId", new Object[]{}));
        }
        final AddressDto responseAddressDto = mapper.map(addressService.update(mapper.map(addressDto, Address.class)), AddressDto.class);
        return new ResponseEntity<>(responseAddressDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        addressService.deleteById(id);
    }
}
