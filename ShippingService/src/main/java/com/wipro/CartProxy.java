package com.wipro;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.entity.Cart;
import com.wipro.entity.CartInventoryDTO;
import com.wipro.entity.LineItems;

@FeignClient("clientCart")
public interface CartProxy {

	@GetMapping("/carts/cart/{cartId}")
	public Cart searchCart(@PathVariable("cartId") long cartId);

	@DeleteMapping("/carts/cart/{cartId}")
	public String emptyCart(@PathVariable("cartId") long cartId);

	@GetMapping("/carts/allCarts")
	public List<Cart> allCarts();

	@PostMapping("/carts/cart")
	public String addCart(@RequestBody CartInventoryDTO cartInventoryDTO);

	@PostMapping("/carts/cartForCustomer")
	public Cart cartForCustomer(@RequestBody Cart cart);

	@PutMapping("/carts/cart/{cartId}/{itemId}")
	public String updateCart(@PathVariable("cartId") long cartId, @RequestBody CartInventoryDTO cartInventoryDTO,
			@PathVariable("itemId") Long itemId);

	@PostMapping("/carts/lineItemForCustomer")
	public LineItems lineItemForCustomer(@RequestBody Cart cart);
}
