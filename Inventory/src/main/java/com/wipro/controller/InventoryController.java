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

import com.wipro.entity.Inventory;
import com.wipro.service.InventoryService;

@RestController
@RequestMapping("/inven")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/inventory")
	public String addInventory(@RequestBody Inventory inventory) {
		
		 Inventory addInventory = inventoryService.addInventory(inventory);
		if (addInventory == null) {
			return "Product with this ID doesn't exists in Product Microservice database or Inventory already "
					+ "exists for this product ID update the details instead of Adding them";
		}
		return "Added the Inventory for this product Id  with the details "+addInventory ;
	}

	@DeleteMapping("/inventory/{productId}")
	public String deleteInventory(@PathVariable("productId") Long productId) {
		return inventoryService.deleteInventory(productId);
	}

	@PutMapping("/inventory/{productId}")
	public String updateInventory(@PathVariable("productId") Long productId, @RequestBody Inventory updatedInventory) {

		return inventoryService.updateInventory(productId, updatedInventory);
	}

	@GetMapping("/inventory/{productId}")
	public Inventory searchInventory(@PathVariable("productId") Long productId) {
		Inventory searchInventory = inventoryService.searchInventory(productId);
		if (searchInventory == null) {
			return null;
		}
		return searchInventory;
	}

}
