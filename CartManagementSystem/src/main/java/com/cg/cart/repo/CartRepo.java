package com.cg.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cart.model.Product;

public interface CartRepo extends JpaRepository<Product, Integer> {

}
