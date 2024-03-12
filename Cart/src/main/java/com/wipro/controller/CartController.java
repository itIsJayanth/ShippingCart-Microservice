package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Cart;
import com.wipro.entity.CartInventoryDTO;
import com.wipro.entity.LineItems;
import com.wipro.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartService cartService;

	@PostMapping("/cart")
	public String addCart(@RequestBody CartInventoryDTO cartInventoryDTO) {
		return cartService.addCart(cartInventoryDTO);
	}

	@PostMapping("/cartForCustomer")
	public Cart cartForCustomer(@RequestBody Cart cart) {
		return cartService.cartForCustomer(cart);
	}

	@PostMapping("/lineItemForCustomer")
	public LineItems lineItemForCustomer(@RequestBody Cart cart) {
		return cartService.lineItemForCustomer(cart);
	}

	@GetMapping("/cart/{cartId}")
	public Cart searchCart(@PathVariable("cartId") long cartId) {
		Cart searchCart = cartService.searchCart(cartId);
		if (searchCart == null) {
			return null;
		}
		return searchCart;
	}

	@DeleteMapping("/cart/{cartId}")
	public String emptyCart(@PathVariable("cartId") long cartId) {
		return cartService.emptyCart(cartId);

	}

	@PutMapping("/cart/{cartId}/{itemId}")
	public String updateCart(@PathVariable("cartId") long cartId, @RequestBody CartInventoryDTO cartInventoryDTO,
			@PathVariable("itemId") Long itemId) {
		return cartService.updateCart(cartId, cartInventoryDTO, itemId);

	}

	@GetMapping("/allCarts")
	public List<Cart> allCarts() {
		return cartService.allCarts();
	}

}
