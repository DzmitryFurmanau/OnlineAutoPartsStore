package com.onlineAutoPartsStore.app.service.impl;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.model.Order;
import com.onlineAutoPartsStore.app.repository.OrderRepository;
import com.onlineAutoPartsStore.app.service.CustomersAddressesService;
import com.onlineAutoPartsStore.app.service.DetailsStocksService;
import com.onlineAutoPartsStore.app.service.OrderService;
import com.onlineAutoPartsStore.app.service.SellerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final SellerService sellerService;

    private final DetailsStocksService detailsStocksService;

    private final CustomersAddressesService customersAddressesService;

    private final LocalizedMessageSource localizedMessageSource;

    public OrderServiceImpl(OrderRepository orderRepository, SellerService sellerService, DetailsStocksService detailsStocksService, CustomersAddressesService customersAddressesService, LocalizedMessageSource localizedMessageSource) {
        this.orderRepository = orderRepository;
        this.sellerService = sellerService;
        this.detailsStocksService = detailsStocksService;
        this.customersAddressesService = customersAddressesService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource.getMessage("error.order.notExist", new Object[]{})));
    }

    @Override
    public Order save(Order order) {
        validate(order.getId() != null, localizedMessageSource.getMessage("error.order.notHaveId", new Object[]{}));
        validate(orderRepository.existsByDate(order.getDate()), localizedMessageSource.getMessage("error.order.date.notUnique", new Object[]{}));
        return saveAndFlush(order);
    }

    @Override
    public Order update(Order order) {
        final Long id = order.getId();
        validate(id == null, localizedMessageSource.getMessage("error.order.haveId", new Object[]{}));
        final Order duplicateOrder = orderRepository.findByDate(order.getDate());
        final boolean isDuplicateExists = duplicateOrder != null && !Objects.equals(duplicateOrder.getId(), id);
        validate(isDuplicateExists, localizedMessageSource.getMessage("error.order.date.notUnique", new Object[]{}));
        findById(id);
        return saveAndFlush(order);
    }


    @Override
    public void delete(Order order) {
        final Long id = order.getId();
        validate(id == null, localizedMessageSource.getMessage("error.order.haveId", new Object[]{}));
        findById(id);
        orderRepository.delete(order);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        orderRepository.deleteById(id);
    }

    private Order saveAndFlush(Order order) {
        validate(order.getSeller() == null || order.getSeller().getId() == null, localizedMessageSource.getMessage("error.order.seller.isNull", new Object[]{}));
        validate(order.getDetailsStocks() == null || order.getDetailsStocks().getId() == null, localizedMessageSource.getMessage("error.order.details_stocks.isNull", new Object[]{}));
        validate(order.getCustomersAddresses() == null || order.getCustomersAddresses().getId() == null, localizedMessageSource.getMessage("error.order.customers_addresses.isNull", new Object[]{}));
        order.setSeller(sellerService.findById(order.getSeller().getId()));
        order.setDetailsStocks(detailsStocksService.findById(order.getDetailsStocks().getId()));
        order.setCustomersAddresses(customersAddressesService.findById(order.getCustomersAddresses().getId()));
        return orderRepository.saveAndFlush(order);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
