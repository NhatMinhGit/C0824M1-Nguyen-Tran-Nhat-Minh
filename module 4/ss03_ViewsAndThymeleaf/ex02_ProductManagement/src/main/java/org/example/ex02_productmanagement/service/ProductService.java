package org.example.ex02_productmanagement.service;
import java.util.List;

import org.example.ex02_productmanagement.model.Product;

public interface ProductService {
    void save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void remove(Long id);

    void update(Long id, Product product);

}
