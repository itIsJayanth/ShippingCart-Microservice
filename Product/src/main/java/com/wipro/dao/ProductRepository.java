package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.entity.*;
public interface ProductRepository extends JpaRepository<Product, Long> {

}
