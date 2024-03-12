package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.CartProxy;
import com.wipro.InventoryProxy;
import com.wipro.ProductProxy;
import com.wipro.dao.LineItemsRepository;
import com.wipro.dao.OrderRepository;
import com.wipro.entity.Cart;
import com.wipro.entity.Inventory;
import com.wipro.entity.LineItems;
import com.wipro.entity.Orderr;
import com.wipro.entity.Product;

@Service

public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private LineItemsRepository lineItemsRepository;
	@Autowired
	private CartProxy cartProxy;
	@Autowired
	private InventoryProxy inventoryProxy;
	@Autowired
	private ProductProxy productProxy;

	@Transactional
	public String addOrder(Orderr orderr, Long cartId) {
		List<Cart> allCarts = cartProxy.allCarts();
		Cart cart = cartProxy.searchCart(cartId);
		if (cart == null) {
			return "Your Cart  doesn't contain this Orderr Check Your Cart Once";
		}

		// Now we need to check our Orderr that has to be placed and Cart which already
		// exists is same or not

		List<LineItems> cartLineItems = cart.getItems();
		List<LineItems> orderLineItems = orderr.getItems();
		if (cartLineItems.size() != orderLineItems.size()) {
			return "Orderr and Cart Didn't match(Size)";
		}
		for (int i = 0; i < cartLineItems.size(); i++) {
			if (!(orderLineItems.get(i).equals(orderLineItems.get(i)))) {
				return "Orderr and Cart Didn't match(Product Details)";
			}
		}
		Orderr toadd = new Orderr(orderr.getOrderId());
		orderRepository.save(toadd);
		for (LineItems item : orderLineItems) {
			LineItems toaddLineItem = new LineItems(item.getItemId(), item.getProductId(), item.getProductName(),
					item.getQuantity(), item.getPrice(), toadd);
			lineItemsRepository.save(toaddLineItem);
		}
		String emptyCart = cartProxy.emptyCart(cartId);
		System.out.println(emptyCart);
		return "Orderr added";
	}
	@Transactional
	public Orderr addOrderFromCart(Cart cart, Long cartId) {
		
		
		List<LineItems> items = cart.getItems();
		Orderr toadd = new Orderr(cart.getCartId());
		Orderr save = orderRepository.save(toadd);
		for (LineItems item : items) {
			LineItems toaddLineItem = new LineItems(item.getItemId(), item.getProductId(), item.getProductName(),
					item.getQuantity(), item.getPrice(), toadd);
			lineItemsRepository.save(toaddLineItem);
		}
		//Orderr fromCart = new Orderr(cart.getCartId());
		String emptyCart = cartProxy.emptyCart(cartId);
		
		System.out.println(emptyCart);
		return save;
	}

	public Orderr searchOrder(Long orderId) {
		return orderRepository.findById(orderId).orElse(null);
	}

	public String emptyOrder(Long orderId) {
		Orderr orElse = orderRepository.findById(orderId).orElse(null);
		if (orElse == null) {
			return "Nothing to delete ";
		}
		orderRepository.deleteById(orderId);
		return "delted You Order";
	}

	public String updateOrder(Orderr updatedOrder, Long orderId) {
		Orderr order = orderRepository.findById(orderId).orElse(null);
		if (order == null) {
			return "No Order Found to update for this ID = " + orderId;
		}

		order.setOrderId(orderId);
		order.setItems(updatedOrder.getItems());
		orderRepository.save(order);

		return "Order Updated";

	}
	
	public void deleteLineItem(Long itemId) {
		lineItemsRepository.deleteById(itemId);
	}

}
