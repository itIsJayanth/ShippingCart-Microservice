package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.Orderr;

public interface OrderRepository extends JpaRepository<Orderr, Long> {

}
