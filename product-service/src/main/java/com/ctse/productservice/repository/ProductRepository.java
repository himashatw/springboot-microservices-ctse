package com.ctse.productservice.repository;

import com.ctse.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, Integer> {

}
