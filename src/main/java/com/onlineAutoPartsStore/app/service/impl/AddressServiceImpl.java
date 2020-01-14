package com.onlineAutoPartsStore.app.service.impl;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.model.Address;
import com.onlineAutoPartsStore.app.repository.AddressRepository;
import com.onlineAutoPartsStore.app.service.AddressService;
import com.onlineAutoPartsStore.app.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type Address service.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final CustomerService customerService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Address service.
     *
     * @param addressRepository      the address repository
     * @param customerService        the customer service
     * @param localizedMessageSource the localized message source
     */
    public AddressServiceImpl(AddressRepository addressRepository,
                              CustomerService customerService,
                              LocalizedMessageSource localizedMessageSource) {
        this.addressRepository = addressRepository;
        this.customerService = customerService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource.getMessage("error.address.notExist", new Object[]{})));
    }

    @Override
    public Address save(Address address) {
        validate(address.getId() != null, localizedMessageSource.getMessage("error.address.notHaveId", new Object[]{}));
        validate(addressRepository.existsByPhoneNumber(address.getPhoneNumber()), localizedMessageSource.getMessage("error.address.phoneNumber.notUnique", new Object[]{}));
        return saveAndFlush(address);
    }

    @Override
    public Address update(Address address) {
        final Long id = address.getId();
        validate(id == null, localizedMessageSource.getMessage("error.address.haveId", new Object[]{}));
        final Address duplicateAddress = addressRepository.findByPhoneNumber(address.getPhoneNumber());
        findById(id);
        final boolean isDuplicateExists = duplicateAddress != null && !Objects.equals(duplicateAddress.getId(), id);
        validate(isDuplicateExists, localizedMessageSource.getMessage("error.address.phoneNumber.notUnique", new Object[]{}));
        return saveAndFlush(address);
    }

    @Override
    public void delete(Address address) {
        final Long id = address.getId();
        validate(id == null, localizedMessageSource.getMessage("error.address.haveId", new Object[]{}));
        findById(id);
        addressRepository.delete(address);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        addressRepository.deleteById(id);
    }

    private Address saveAndFlush(Address address) {
        address.getCustomers().forEach(customer -> {
            validate(customer == null || customer.getId() == null,
                    localizedMessageSource.getMessage("error.address.customers.isNull", new Object[]{}));
            customer.setName(customerService.findById(customer.getId()).getName());
        });
        return addressRepository.saveAndFlush(address);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
