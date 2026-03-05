package com.project.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.products.model.Product;
import com.project.products.repository.ProductRepositoryJPA;

@Service
public class ProductServiceJPA implements ProductService {

    private final ProductRepositoryJPA productRepository;

    public ProductServiceJPA(ProductRepositoryJPA productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("Creating product: " + product.getName());
        
        return productRepository.save(product);
    }

    @Override
    public List<Product> listProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());

        return this.productRepository.save(existingProduct);

        /* 
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock());
            this.productRepository.save(existingProduct);
            return existingProduct;
        } else {
            throw new RuntimeException("Product not found with id: " + product.getId());
        } */
    }

    @Override
    public Product deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        this.productRepository.delete(existingProduct);

        return existingProduct;
        /* 
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return existingProduct;
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }*/
    }

}
