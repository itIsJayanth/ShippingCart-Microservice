package com.wipro.controller;

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
import com.wipro.entity.Orderr;
import com.wipro.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/order/{cartId}")
	public String addOrder(@RequestBody Orderr orderr, @PathVariable("cartId") Long cartId) {
		return orderService.addOrder(orderr, cartId);
	}
	@PostMapping("/order/cart/{cartId}")
	public Orderr addOrderFromCart(@RequestBody Cart cart,@PathVariable("cartId")Long cartId) {
		return orderService.addOrderFromCart(cart, cartId);
	}

	@GetMapping("/order/{orderId}")
	public Orderr searchOrder(@PathVariable("orderId") Long orderId) {
		return orderService.searchOrder(orderId);
	}

	@DeleteMapping("order/{orderId}")
	public String emptyOrder(@PathVariable("orderId") Long orderId) {

		return orderService.emptyOrder(orderId);
	}
	
	@PutMapping("order/{orderId}")
	public String updateOrder(@RequestBody Orderr updatedOrder,@PathVariable("orderId")Long orderId) {
		return orderService.updateOrder(updatedOrder, orderId);
	}
	
	@DeleteMapping("lineItem/{itemId}")
	public void deleteLineItem(@PathVariable("itemId")Long itemId){
		orderService.deleteLineItem(itemId);
	}
}
