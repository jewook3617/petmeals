package com.example.petmeal.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
	Optional<List<Order>> findAllByBuyerId(Long buyerId);
}