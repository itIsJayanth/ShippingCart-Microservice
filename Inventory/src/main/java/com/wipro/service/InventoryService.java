package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ProductProxy;
import com.wipro.dao.InventoryRepository;
import com.wipro.entity.Inventory;
import com.wipro.entity.Product;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private ProductProxy productProxy;

	public Inventory addInventory(Inventory inventory) {

		Long productId = inventory.getProductId();
		Product searchProduct = productProxy.searchProduct(productId);
		if (searchProduct == null) {
			System.out.println(
					"Product With this product ID " + productId + " dont exixts in product Microservice database");
			return null;
		}
		// to check inventory details already exists for this product ID
		Inventory findAlreadyProductId = inventoryRepository.findByProductId(inventory.getProductId());
		if (findAlreadyProductId != null) {
			System.out.println("Inventory Already exixts for this Product");
			return null;
		}

		else {
			System.out.println("You have a Product WIth this ID in the Product Microservoce Database");
			System.out.println("Now You can add the quantity details in the inventory Microservice");
			System.out.println(searchProduct);
			return inventoryRepository.save(inventory);

		}
	}

	public String deleteInventory(Long productId) {
		Inventory inventory = inventoryRepository.findByProductId(productId);
		if (inventory == null) {
			return "Inventory Doesn't exists to delete";
		} else {
			inventoryRepository.delete(inventory);
			return "Inventory Deleted";
		}
	}

	public String updateInventory(Long prodcutId, Inventory updaInventory) {
		Inventory findByProductId = inventoryRepository.findByProductId(prodcutId);
		if (findByProductId == null) {
			return "Inventory Doesn't exists nothing Updated";
		}
		findByProductId.setProductId(updaInventory.getProductId());
		findByProductId.setQuantity(updaInventory.getQuantity());
		inventoryRepository.save(findByProductId);
		return "Inventory Updated with these details :=> " + findByProductId;
	}

	public Inventory searchInventory(Long productId) {

		Inventory inventory = inventoryRepository.findByProductId(productId);
		if (inventory == null) {
			return null;
		}

		return inventory;

	}
}
