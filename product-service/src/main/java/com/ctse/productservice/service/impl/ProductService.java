package com.ctse.productservice.service.impl;

import com.ctse.productservice.entity.Product;
// import com.ctse.productservice.resource.;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public Product addProduct(Product product);

    public String deleteById(int id);

}
