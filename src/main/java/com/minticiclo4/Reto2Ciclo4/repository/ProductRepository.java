/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minticiclo4.Reto2Ciclo4.repository;

import com.minticiclo4.Reto2Ciclo4.model.Product;
import com.minticiclo4.Reto2Ciclo4.repository.crud.ProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Alvaro Rojas Rincon
 */
@Repository
public class ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    public List<Product> getAll(){
        return productCrudRepository.findAll();
    }
    public Optional<Product> getProduct(String reference){
        return productCrudRepository.findById(reference);
    }
    public Product save(Product product){
        return productCrudRepository.save(product);
    }
    public void update(Product product){
       productCrudRepository.save(product);
    }
    public void delete(Product product){
        productCrudRepository.delete(product);
    }
}
