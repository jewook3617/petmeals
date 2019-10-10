package com.example.petmeal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import com.example.petmeal.domain.Products;
import com.example.petmeal.domain.ProductsRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Transactional
    public Optional<Products> findByProductsId(Long id){
        return productsRepository.findById(id);
    }
    
    @Transactional
    public List<Products> findAll(){
        return productsRepository.findAll();
    }
}