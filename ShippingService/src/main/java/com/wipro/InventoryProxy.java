package com.wipro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.entity.Inventory;

@FeignClient("clientInventory")
public interface InventoryProxy {
	@GetMapping("/inven/inventory/{productId}")
	public Inventory searchInventory(@PathVariable("productId") Long productId);

	@PutMapping("/inven/inventory/{productId}")
	public String updateInventory(@PathVariable("productId") Long productId, @RequestBody Inventory updatedInventory);

	@PostMapping("/inven/inventory")
	public String addInventory(@RequestBody Inventory inventory);

}
