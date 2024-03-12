package com.wipro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.ProductRepository;
import com.wipro.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product) {

		return productRepository.save(product);

	}

	public String deleteProduct(Long id) {
		Optional<Product> findById = productRepository.findById(id);
		if(findById.isEmpty()) {
			return "No Product found  for this ID = "+id; 
		}
		productRepository.deleteById(id);
		return "Product Delted for the Id = " +id;
	}

	public Product updateProduct(Long id, Product updatedProduct) {

		Optional<Product> pro = productRepository.findById(id);
		if(pro.isEmpty()) {
			return null;
		}
		Product product = pro.get();
		product.setProductDescription(updatedProduct.getProductDescription());
		product.setProductName(updatedProduct.getProductName());
		product.setProductPrice(updatedProduct.getProductPrice());
		return productRepository.save(product);
	}

	public Product searchProduct(Long id) {
		Optional<Product> findById = productRepository.findById(id);
		if(findById.isEmpty()) {
			return null;
		}
		Product product = findById.get();
		return product;
	}
}
