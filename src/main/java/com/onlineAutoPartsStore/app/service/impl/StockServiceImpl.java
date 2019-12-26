package com.onlineAutoPartsStore.app.service.impl;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.model.Stock;
import com.onlineAutoPartsStore.app.repository.StockRepository;
import com.onlineAutoPartsStore.app.service.HeaverService;
import com.onlineAutoPartsStore.app.service.ProviderService;
import com.onlineAutoPartsStore.app.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    private final LocalizedMessageSource localizedMessageSource;

    private final ProviderService providerService;

    private final HeaverService heaverService;

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository, ProviderService providerService, HeaverService heaverService, LocalizedMessageSource localizedMessageSource) {
        this.stockRepository = stockRepository;
        this.providerService = providerService;
        this.heaverService = heaverService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findById(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource.getMessage("error.stock.notExist", new Object[]{})));
    }

    @Override
    public Stock save(Stock stock) {
        validate(stock.getId() != null, localizedMessageSource.getMessage("error.stock.notHaveId", new Object[]{}));
        validate(stockRepository.existsById(stock.getId()), localizedMessageSource.getMessage("error.stock.id.notUnique", new Object[]{}));
        return saveAndFlush(stock);
    }

    @Override
    public Stock update(Stock stock) {
        final Long id = stock.getId();
        validate(id == null, localizedMessageSource.getMessage("error.stock.haveId", new Object[]{}));
        findById(id);
        return saveAndFlush(stock);
    }


    @Override
    public void delete(Stock stock) {
        final Long id = stock.getId();
        validate(id == null, localizedMessageSource.getMessage("error.stock.haveId", new Object[]{}));
        findById(id);
        stockRepository.delete(stock);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        stockRepository.deleteById(id);
    }

    private Stock saveAndFlush(Stock stock) {
        validate(stock.getProvider() == null || stock.getProvider().getId() == null, localizedMessageSource.getMessage("error.stock.provider.isNull", new Object[]{}));
        validate(stock.getHeaver() == null || stock.getHeaver().getId() == null, localizedMessageSource.getMessage("error.stock.heaver.isNull", new Object[]{}));
        stock.setProvider(providerService.findById(stock.getProvider().getId()));
        stock.setHeaver(heaverService.findById(stock.getHeaver().getId()));
        return stockRepository.saveAndFlush(stock);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
