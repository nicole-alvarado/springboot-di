package com.nicole.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.nicole.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    // ejemplo sin inyección de dependencias
    private List<Product> data;

    public ProductRepository(){
        this.data = Arrays.asList(
            new Product(1L,"Memoria Corsair 32", 300L),
            new Product(2L,"CPU Intel Core i9", 450L),
            new Product(3L,"Teclado Razer Mini 60%", 180L),
            new Product(4L,"Motherboard Gigabyte", 490L)
        );
    }

    public List<Product> findAll(){
        return data;
    }

    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
