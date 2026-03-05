package com.project.products.service;

import java.util.List;

import com.project.products.model.Product;

public interface ProductService {

    public Product createProduct(Product product);
    public List<Product> listProducts();
    public Product updateProduct(Long id, Product product);
    public Product deleteProduct(Long id);
}
