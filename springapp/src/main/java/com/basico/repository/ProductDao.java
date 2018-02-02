package com.basico.repository;

import java.util.List;

import com.basico.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}