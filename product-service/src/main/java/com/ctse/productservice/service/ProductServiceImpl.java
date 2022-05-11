package com.ctse.productservice.service;

import com.ctse.productservice.entity.Product;
import com.ctse.productservice.repository.ProductRepository;
import com.ctse.productservice.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public String deleteById(int id) {
        Product product = new Product();
        int pId = product.getId();
        if(pId != id) {
            productRepository.deleteById(id);
            return "Product Id "+ id +" Deleted Successfully";
        }else {
            return "Product id is Invalid";
        }
    }

}
