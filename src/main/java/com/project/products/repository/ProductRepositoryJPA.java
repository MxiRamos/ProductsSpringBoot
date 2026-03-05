package com.project.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.products.model.Product;
import java.util.List;


@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
}
