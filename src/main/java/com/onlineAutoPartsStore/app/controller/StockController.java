package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.StockRequestDto;
import com.onlineAutoPartsStore.app.dto.response.StockResponseDto;
import com.onlineAutoPartsStore.app.model.Heaver;
import com.onlineAutoPartsStore.app.model.Provider;
import com.onlineAutoPartsStore.app.model.Stock;
import com.onlineAutoPartsStore.app.service.StockService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Stock controller.
 */
@RestController
@RequestMapping("/stocks")
public class StockController {

    private final Mapper mapper;

    private final StockService stockService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Stock controller.
     *
     * @param mapper                 the mapper
     * @param stockService           the stock service
     * @param localizedMessageSource the localized message source
     */
    public StockController(Mapper mapper, StockService stockService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.stockService = stockService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<StockResponseDto>> getAll() {
        final List<Stock> stocks = stockService.findAll();
        final List<StockResponseDto> stockResponseDtoList = stocks.stream()
                .map((stock) -> mapper.map(stock, StockResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(stockResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<StockResponseDto> getOne(@PathVariable Long id) {
        final StockResponseDto stockResponseDto = mapper.map(stockService.findById(id), StockResponseDto.class);
        return new ResponseEntity<>(stockResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param stockRequestDto the stock request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<StockResponseDto> save(@RequestBody StockRequestDto stockRequestDto) {
        stockRequestDto.setId(null);
        final StockResponseDto stockResponseDto = mapper.map(stockService.save(getStock(stockRequestDto)), StockResponseDto.class);
        return new ResponseEntity<>(stockResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param stockRequestDto the stock request dto
     * @param id              the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<StockResponseDto> update(@RequestBody StockRequestDto stockRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, stockRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.stock.unexpectedId", new Object[]{}));
        }
        final StockResponseDto stockResponseDto = mapper.map(stockService.update(getStock(stockRequestDto)), StockResponseDto.class);
        return new ResponseEntity<>(stockResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        stockService.deleteById(id);
    }

    private Stock getStock(StockRequestDto stockRequestDto) {
        final Stock stock = mapper.map(stockRequestDto, Stock.class);
        final Provider provider = new Provider();
        final Heaver heaver = new Heaver();
        provider.setId(stockRequestDto.getProviderId());
        heaver.setId(stockRequestDto.getHeaverId());
        stock.setProvider(provider);
        stock.setHeaver(heaver);
        return stock;
    }
}
