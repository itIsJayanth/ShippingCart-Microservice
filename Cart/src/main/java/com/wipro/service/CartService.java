package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.InventoryProxy;
import com.wipro.ProductProxy;
import com.wipro.dao.CartRepository;
import com.wipro.dao.LineItemsRepository;
import com.wipro.entity.Cart;
import com.wipro.entity.CartInventoryDTO;
import com.wipro.entity.Inventory;
import com.wipro.entity.LineItems;
import com.wipro.entity.Product;

@Service

public class CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private LineItemsRepository lineItemsRepository;
	@Autowired
	private ProductProxy productProxy;
	@Autowired
	private InventoryProxy inventoryProxy;

	@Transactional
	public String addCart(CartInventoryDTO cartInventoryDTO) {

//    id entered while adding products to cart by customer
		Long productId = cartInventoryDTO.getProductId();
//now i will check whether  this product Id exists in product microservice
//     are if
//{  product name should match , and i will check the quantity the 
//	customer is asking exists in inventory  and  if it exists i have to modify 
//	   the inventory from here(reduce the inventory)
//		
//}
		Product searchProduct = productProxy.searchProduct(productId);
		Inventory searchInventory = inventoryProxy.searchInventory(productId);
		if (searchProduct == null) {
			return "The Product You are trying to add is not available ";
		} else {
			if (!(searchProduct.getProductName().equalsIgnoreCase(cartInventoryDTO.getProductName()))) {
				return "The Product Names dont match";
			}
			if (!(searchProduct.getProductPrice() == cartInventoryDTO.getPrice())) {
				return "The Product  Price  dont match";
			}
			if (searchInventory == null) {
				return "Update Your Inventory";
			}
			if (searchInventory.getQuantity() < cartInventoryDTO.getQuantity()) {
				return "We don't have the quantity you are asking";
			}

			Cart cart = new Cart(cartInventoryDTO.getCartId());
			LineItems items = new LineItems(cartInventoryDTO.getProductId(), cartInventoryDTO.getProductName(),
					cartInventoryDTO.getQuantity(), cartInventoryDTO.getPrice(), cart);
			cartRepository.save(cart);
			lineItemsRepository.save(items);
			searchInventory.setQuantity(searchInventory.getQuantity() - cartInventoryDTO.getQuantity());
			inventoryProxy.updateInventory(productId, searchInventory);
			return "Added To Cart ";
		}
	}

	@Transactional
	public Cart cartForCustomer(Cart cart) {
		LineItems items = new LineItems(cart);
		Cart save = cartRepository.save(cart);
		 lineItemsRepository.save(items);
		return save;
	}
	@Transactional
	public LineItems lineItemForCustomer(Cart cart) {
		LineItems items = new LineItems(cart);
		return lineItemsRepository.save(items);
	}

	public Cart searchCart(Long cartId) {
		return cartRepository.findById(cartId).orElse(null);

	}

	public String emptyCart(Long cartId) {
		Optional<Cart> findById = cartRepository.findById(cartId);
		if (findById.isEmpty()) {
			return "No Cart with such ID = " + cartId;
		}
		cartRepository.deleteById(cartId);
		return "Deleted Your Cart";
	}

	public String updateCart(Long cartId, CartInventoryDTO catCartInventoryDTO,Long itemId) {
		Cart cart = cartRepository.findById(cartId).orElse(null);
		if (cart == null) {
			return "Cart doesn't exists to update";
		}
		
		
		LineItems lineitem = lineItemsRepository.findById(itemId).orElse(null);
		if (lineitem == null) {
			return "Item doesnot exists";
		}

		long productId = catCartInventoryDTO.getProductId();
		Product searchProduct = productProxy.searchProduct(productId);
		Inventory searchInventory = inventoryProxy.searchInventory(productId);
		if (searchProduct == null) {
			return "The Product You are trying to update is not available ";
		} else {
			if (!(searchProduct.getProductName().equalsIgnoreCase(catCartInventoryDTO.getProductName()))) {
				return "The Updated Product Names dont match";
			}
			if (!(searchProduct.getProductPrice() == catCartInventoryDTO.getPrice())) {
				return "The Updated Product  Price  dont match";
			}
			if (searchInventory == null) {
				return "Update Your Inventory";
			}
			if (searchInventory.getQuantity() < catCartInventoryDTO.getQuantity()) {
				return "We don't have the quantity you are asking";
			}
			
			
			cartRepository.save(cart);
			lineitem.setItemId(catCartInventoryDTO.getItemId());
			lineitem.setProductId(catCartInventoryDTO.getProductId());
			lineitem.setProductName(catCartInventoryDTO.getProductName());
			lineitem.setPrice(catCartInventoryDTO.getPrice());
			lineitem.setQuantity(catCartInventoryDTO.getQuantity());
			lineItemsRepository.save(lineitem);
			searchInventory.setQuantity(searchInventory.getQuantity() - catCartInventoryDTO.getQuantity());
			inventoryProxy.updateInventory(productId, searchInventory);
			return "Updated Your Cart";
		}
	}

	public List<Cart> allCarts() {
		return cartRepository.findAll();
	}
}
