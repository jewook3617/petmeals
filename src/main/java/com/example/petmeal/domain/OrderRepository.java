package com.example.petmeal.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findBybuyerId(Long buyerId);
}