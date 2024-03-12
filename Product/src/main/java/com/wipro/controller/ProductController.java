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

import com.wipro.entity.Product;
import com.wipro.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		Product addProduct = productService.addProduct(product);
		return addProduct;
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		return productService.deleteProduct(id);

	}

	@PutMapping("/products/{id}")
	public String updateProduct(@RequestBody Product updatedProduct, @PathVariable("id") Long id) {
		Product updateProduct = productService.updateProduct(id, updatedProduct);
		if (updateProduct == null) {
			return "No product Found To Update with this ID = " + id;
		}
		return "Product Updated Details " + updateProduct;
	}

	@GetMapping("/products/{id}")
	public Product searchProduct(@PathVariable("id") Long id) {
		return productService.searchProduct(id);
	}
}
