package com.wipro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.entity.Cart;
import com.wipro.entity.Orderr;

@FeignClient("clientOrder")
public interface OrderProxy {
	@PostMapping("/orders/order/{cartId}")
	public String addOrder(@RequestBody Orderr orderr, @PathVariable("cartId") Long cartId);

	@GetMapping("/orders/order/{orderId}")
	public Orderr searchOrder(@PathVariable("orderId") Long orderId);

	@DeleteMapping("/orders/order/{orderId}")
	public String emptyOrder(@PathVariable("orderId") Long orderId);

	@PutMapping("/orders/order/{orderId}")
	public String updateOrder(@RequestBody Orderr updatedOrder, @PathVariable("orderId") Long orderId);

	@PostMapping("/orders/order/cart/{cartId}")
	public Orderr addOrderFromCart(@RequestBody Cart cart,@PathVariable("cartId")Long cartId);
	
	@DeleteMapping("/orders/lineItem/{itemId}")
	public void deleteLineItem(@PathVariable("itemId")Long itemId);
		
}
