/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minticiclo4.Reto2Ciclo4.service;

import com.minticiclo4.Reto2Ciclo4.model.Product;
import com.minticiclo4.Reto2Ciclo4.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Alvaro Rojas Rincon
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public  List<Product> getAll(){
        return productRepository.getAll();
    }
    public  Optional<Product> getProduct(String reference){
        return productRepository.getProduct(reference);
    }
    public Product save(Product product){
        if (product.getReference() == null){
            return product; 
        }
        return productRepository.save(product);
    }
    public Product update(Product product){
        if (product.getCategory()!= null){
            Optional<Product> dbProduct = productRepository.getProduct(product.getCategory());
            if (!dbProduct.isEmpty()){
                if (product.getBrand()!= null){
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory()!= null){
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getDescription()!= null){
                    dbProduct.get().setDescription(product.getDescription());
                }                
                
                dbProduct.get().setAvailability(product.isAvailability());

                if (product.getPrice()!= 0.0){
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity()!= 0){
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!= null){
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }
    public boolean delete(String reference){
        return getProduct(reference).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }
}