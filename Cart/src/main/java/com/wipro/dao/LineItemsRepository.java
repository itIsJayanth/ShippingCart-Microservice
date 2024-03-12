package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.LineItems;

public interface LineItemsRepository extends JpaRepository<LineItems, Long> {

}
