/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minticiclo4.Reto2Ciclo4.repository.crud;

import com.minticiclo4.Reto2Ciclo4.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author Luis Alvaro Rojas Rincon
 */
public interface ProductCrudRepository extends MongoRepository<Product, String>{
    
}
