package com.onlineAutoPartsStore.app.service;

import com.onlineAutoPartsStore.app.model.Seller;

import java.util.List;

public interface SellerService {

    List<Seller> findAll();

    Seller findById(Long id);

    Seller save(Seller seller);

    Seller update(Seller seller);

    void delete(Seller seller);

    void deleteById(Long id);

}
