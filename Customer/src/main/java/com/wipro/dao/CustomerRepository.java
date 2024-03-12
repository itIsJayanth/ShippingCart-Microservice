package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.entity.*;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
