package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.SellerRequestDto;
import com.onlineAutoPartsStore.app.dto.response.SellerResponseDto;
import com.onlineAutoPartsStore.app.model.Seller;
import com.onlineAutoPartsStore.app.service.SellerService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final Mapper mapper;

    private final SellerService sellerService;

    private final LocalizedMessageSource localizedMessageSource;

    public SellerController(Mapper mapper, SellerService sellerService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.sellerService = sellerService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @GetMapping
    public ResponseEntity<List<SellerResponseDto>> getAll() {
        final List<Seller> sellers = sellerService.findAll();
        final List<SellerResponseDto> sellerResponseDtoList = sellers.stream()
                .map((seller) -> mapper.map(seller, SellerResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(sellerResponseDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SellerResponseDto> getOne(@PathVariable Long id) {
        final SellerResponseDto sellerResponseDto = mapper.map(sellerService.findById(id), SellerResponseDto.class);
        return new ResponseEntity<>(sellerResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SellerResponseDto> save(@RequestBody SellerRequestDto sellerRequestDto) {
        sellerRequestDto.setId(null);
        final SellerResponseDto sellerResponseDto = mapper.map(sellerService.save(mapper.map(sellerRequestDto, Seller.class)), SellerResponseDto.class);
        return new ResponseEntity<>(sellerResponseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SellerResponseDto> update(@RequestBody SellerRequestDto sellerRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, sellerRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.seller.unexpectedId", new Object[]{}));
        }
        final SellerResponseDto sellerResponseDto = mapper.map(sellerService.update(mapper.map(sellerRequestDto, Seller.class)), SellerResponseDto.class);
        return new ResponseEntity<>(sellerResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        sellerService.deleteById(id);
    }
}
