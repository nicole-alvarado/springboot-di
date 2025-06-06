package com.nicole.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.nicole.springboot.di.app.springboot_di.models.Product;
import com.nicole.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll(){
        
        return repository.findAll().stream().map(p -> {
            Double priceImpost = p.getPrice() * 1.25d;
            Product newProduct = new Product(p.getId(),p.getName(),priceImpost.longValue()); // Cumplir con el principio de inmutabilidad, ya que el objeto es distinto
            //p.setPrice(priceImpost.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }
}
