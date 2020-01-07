package com.onlineAutoPartsStore.app.service.impl;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.model.DetailsStocks;
import com.onlineAutoPartsStore.app.repository.DetailsStocksRepository;
import com.onlineAutoPartsStore.app.service.DetailService;
import com.onlineAutoPartsStore.app.service.DetailsStocksService;
import com.onlineAutoPartsStore.app.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The type Details stocks service.
 */
@Service
@Transactional
public class DetailsStocksServiceImpl implements DetailsStocksService {

    private final DetailsStocksRepository detailsStocksRepository;

    private final StockService stockService;

    private final DetailService detailService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Details stocks service.
     *
     * @param detailsStocksRepository the details stocks repository
     * @param stockService            the stock service
     * @param detailService           the detail service
     * @param localizedMessageSource  the localized message source
     */
    public DetailsStocksServiceImpl(DetailsStocksRepository detailsStocksRepository, StockService stockService, DetailService detailService, LocalizedMessageSource localizedMessageSource) {
        this.detailsStocksRepository = detailsStocksRepository;
        this.stockService = stockService;
        this.detailService = detailService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<DetailsStocks> findAll() {
        return detailsStocksRepository.findAll();
    }

    @Override
    public DetailsStocks findById(Long id) {
        return detailsStocksRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource.getMessage("error.details_stocks.notExist", new Object[]{})));
    }

    @Override
    public DetailsStocks save(DetailsStocks detailsStocks) {
        validate(detailsStocks.getId() != null, localizedMessageSource.getMessage("error.details_stocks.notHaveId", new Object[]{}));
        validate(detailsStocksRepository.existsById(detailsStocks.getId()), localizedMessageSource.getMessage("error.details_stocks.id.notUnique", new Object[]{}));
        return saveAndFlush(detailsStocks);
    }

    @Override
    public DetailsStocks update(DetailsStocks detailsStocks) {
        final Long id = detailsStocks.getId();
        validate(id == null, localizedMessageSource.getMessage("error.details_stocks.haveId", new Object[]{}));
        final Optional<DetailsStocks> duplicatedetailsStocks = detailsStocksRepository.findById(detailsStocks.getId());
        final boolean isDuplicateExists = duplicatedetailsStocks.isPresent();
        validate(isDuplicateExists, localizedMessageSource.getMessage("error.details_stocks.id.notUnique", new Object[]{}));
        findById(id);
        return saveAndFlush(detailsStocks);
    }


    @Override
    public void delete(DetailsStocks detailsStocks) {
        final Long id = detailsStocks.getId();
        validate(id == null, localizedMessageSource.getMessage("error.details_stocks.haveId", new Object[]{}));
        findById(id);
        detailsStocksRepository.delete(detailsStocks);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        detailsStocksRepository.deleteById(id);
    }

    private DetailsStocks saveAndFlush(DetailsStocks detailsStocks) {
        validate(detailsStocks.getStock() == null || detailsStocks.getStock().getId() == null, localizedMessageSource.getMessage("error.details_stocks.stock.isNull", new Object[]{}));
        validate(detailsStocks.getDetail() == null || detailsStocks.getDetail().getId() == null, localizedMessageSource.getMessage("error.details_stocks.detail.isNull", new Object[]{}));
        detailsStocks.setStock(stockService.findById(detailsStocks.getStock().getId()));
        detailsStocks.setDetail(detailService.findById(detailsStocks.getDetail().getId()));
        return detailsStocksRepository.saveAndFlush(detailsStocks);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
