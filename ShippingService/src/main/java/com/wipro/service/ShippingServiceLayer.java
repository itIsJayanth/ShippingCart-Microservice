package com.wipro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.CartProxy;
import com.wipro.CustomerProxy;
import com.wipro.InventoryProxy;
import com.wipro.OrderProxy;
import com.wipro.ProductProxy;
import com.wipro.dao.ShippinServiceRepository;
import com.wipro.dao.ShippingServiceCustomerOrderRepository;
import com.wipro.entity.Cart;
import com.wipro.entity.CartInventoryDTO;
import com.wipro.entity.Customer;
import com.wipro.entity.Inventory;
import com.wipro.entity.LineItems;
import com.wipro.entity.Orderr;
import com.wipro.entity.Product;
import com.wipro.entity.ShippingRequest;
import com.wipro.entity.ShippingServiceCustomerOrder;
import com.wipro.entity.ShippingServiceTable;

@Service
public class ShippingServiceLayer {
	@Autowired
	ProductProxy productProxy;
	@Autowired
	InventoryProxy inventoryProxy;
	@Autowired
	CustomerProxy customerProxy;
	@Autowired
	CartProxy cartProxy;
	@Autowired
	ShippinServiceRepository shippinServiceRepository;
	@Autowired
	OrderProxy orderProxy;
	@Autowired
	ShippingServiceCustomerOrderRepository shippingServiceCustomerOrderRepository;

	public String performProduct(ShippingRequest sr) {

		Product pro = new Product(sr.getProductName(), sr.getProductDescription(), sr.getProductPrice());
		Product addProduct = productProxy.addProduct(pro);
		Long productId = addProduct.getProductId();
		Inventory inv = new Inventory(productId, sr.getQuantity());
		inventoryProxy.addInventory(inv);
		return "Product Created and Inventory Added";

	}

	public ShippingServiceTable performCustomer(Customer cus) {
		Customer addCustomer = customerProxy.addCustomer(cus);
		Long customerId = addCustomer.getId();
		Cart cart = new Cart(customerId + 1);
		Cart cartForCustomer = cartProxy.cartForCustomer(cart);
		Long cartId = cartForCustomer.getCartId();
		ShippingServiceTable shippingServiceTable = new ShippingServiceTable(customerId, cartId);
		return shippinServiceRepository.save(shippingServiceTable);

	}

	public String performCustomerUpdate(Long customerId, CartInventoryDTO cartInventoryDTO) {
		ShippingServiceTable findByCustomerId = shippinServiceRepository.findByCustomerId(customerId);
		String updateCart = cartProxy.updateCart(findByCustomerId.getCartId(), cartInventoryDTO,
				cartInventoryDTO.getItemId());
		if (updateCart.equalsIgnoreCase("Updated Your Cart")) {
			Cart searchCart = cartProxy.searchCart(cartInventoryDTO.getCartId());
			cartProxy.lineItemForCustomer(searchCart);
		}
		return updateCart;
	}

	public String performCustomerOrder(Long customerId) {
		ShippingServiceTable findByCustomerId = shippinServiceRepository.findByCustomerId(customerId);
		if (findByCustomerId != null) {
			Long cartId = findByCustomerId.getCartId();
			Cart searchCart = cartProxy.searchCart(cartId);
			Orderr addOrder = orderProxy.addOrderFromCart(searchCart, cartId);
			Long orderId = addOrder.getOrderId();
			ShippingServiceCustomerOrder shippingServiceCustomerOrder = new ShippingServiceCustomerOrder(customerId,
					orderId);
			shippingServiceCustomerOrderRepository.save(shippingServiceCustomerOrder);
			return "Done " + addOrder;
		}
		return "customer Cart doesn't exists create your cart first";
	}
	
	public Orderr performGetCustomerOrder(Long customerId)
	{
		ShippingServiceCustomerOrder findByCustomerId = shippingServiceCustomerOrderRepository.findByCustomerId(customerId);
		Long orderId = findByCustomerId.getOrderId();
		Orderr searchOrder = orderProxy.searchOrder(orderId);
		List<LineItems> items = searchOrder.getItems();
//		for(LineItems item : items ) {
//			if(item.getProductId()==null) {
//				orderProxy.deleteLineItem(item.getItemId());
//			}
//		}
		Orderr searchOrder2 = new Orderr();
		searchOrder2.setOrderId(searchOrder.getOrderId());
		List<LineItems> notNullItems = new ArrayList<>();
		
		for(LineItems item : items) {
			if(item.getQuantity()!=0) {
				notNullItems.add(item);
			}
			
		}
		searchOrder2.setItems(notNullItems);
		return searchOrder2;
	}

}
