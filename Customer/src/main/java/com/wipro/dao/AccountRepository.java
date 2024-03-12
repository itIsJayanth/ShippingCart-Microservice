package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.Address;

public interface AccountRepository extends JpaRepository<Address, Long> {

}
