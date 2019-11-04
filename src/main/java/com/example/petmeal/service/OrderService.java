package com.example.petmeal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.petmeal.domain.Order;
import com.example.petmeal.domain.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Transactional
    public void save(Order order){
    	orderRepository.save(order);
    }
    
    @Transactional
    public Optional<Order> findOrderById(Long id){
    	return orderRepository.findById(id);  
    }
    
    @Transactional
    public Optional<List<Order>> findOrderByBuyerId(Long buyerId){
    	return orderRepository.findAllByBuyerId(buyerId);  
    }
}