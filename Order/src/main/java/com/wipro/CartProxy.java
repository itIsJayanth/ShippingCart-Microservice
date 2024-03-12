package com.wipro;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.entity.Cart;

@FeignClient("clientCart")
public interface CartProxy {

	@GetMapping("/carts/cart/{cartId}")
	public Cart searchCart(@PathVariable("cartId") long cartId);

	@DeleteMapping("/carts/cart/{cartId}")
	public String emptyCart(@PathVariable("cartId") long cartId);

	@GetMapping("/carts/allCarts")
	public List<Cart> allCarts();
}
