package org.example.ex02_productmanagement.service.impl;

import org.example.ex02_productmanagement.model.Product;
import org.example.ex02_productmanagement.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<Long, Product> products;

    static {
        products = new HashMap<>();
        products.put(1L, new Product(1L, "John",10000.0, "john@codegym.vn", "Ha Noi"));
        products.put(2L, new Product(2L, "Bill",10000.0, "bill@codegym.vn", "Hai Phong"));
        products.put(3L, new Product(3L, "Alex",10000.0, "alex@codegym.vn", "Sai Gon"));
        products.put(4L, new Product(4L, "Adam",10000.0, "adam@codegym.vn", "Beijing"));
        products.put(5L, new Product(5L, "Sophia",10000.0, "sophia@codegym.vn", "Miami"));
        products.put(6L, new Product(6L, "Rose",10000.0, "rose@codegym.vn", "NewYork"));
    }
    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void remove(Long id) {
        products.remove(id);
    }

    @Override
    public void update(Long id, Product product) {
        products.put(id, product);
    }
}
