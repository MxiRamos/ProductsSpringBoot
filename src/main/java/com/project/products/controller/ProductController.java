package com.project.products.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.products.model.Product;
import com.project.products.service.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @PostMapping("/crear")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    
    @PutMapping("/actualizar/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/eliminar/{id}")
    public Product deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }


}
