package com.onlineAutoPartsStore.app.service.impl;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.model.Customer;
import com.onlineAutoPartsStore.app.repository.CustomerRepository;
import com.onlineAutoPartsStore.app.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final LocalizedMessageSource localizedMessageSource;

    public CustomerServiceImpl(CustomerRepository customerRepository, LocalizedMessageSource localizedMessageSource) {
        this.customerRepository = customerRepository;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource.getMessage("error.customer.notExist", new Object[]{})));
    }

    @Override
    public Customer save(Customer customer) {
        validate(customer.getId() != null, localizedMessageSource.getMessage("error.customer.notHaveId", new Object[]{}));
        validate(customerRepository.existsByName(customer.getName()), localizedMessageSource.getMessage("error.customer.name.notUnique", new Object[]{}));
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer update(Customer customer) {
        final Long id = customer.getId();
        validate(id == null, localizedMessageSource.getMessage("error.customer.haveId", new Object[]{}));
        final Customer duplicateCustomer = customerRepository.findByName(customer.getName());
        final boolean isDuplicateExists = duplicateCustomer != null && !Objects.equals(duplicateCustomer.getId(), id);
        validate(isDuplicateExists, localizedMessageSource.getMessage("error.customer.name.notUnique", new Object[]{}));
        findById(id);
        return customerRepository.saveAndFlush(customer);
    }


    @Override
    public void delete(Customer customer) {
        final Long id = customer.getId();
        validate(id == null, localizedMessageSource.getMessage("error.customer.haveId", new Object[]{}));
        findById(id);
        customerRepository.delete(customer);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        customerRepository.deleteById(id);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
