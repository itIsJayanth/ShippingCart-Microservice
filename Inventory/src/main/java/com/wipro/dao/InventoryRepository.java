package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	Inventory findByProductId(Long productId);
}
