package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wipro.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	@Query("SELECT c FROM Cart c JOIN FETCH c.items where c.cartId = :cartId")
	Cart findCart(@Param("cartId") Long cartId);
}
