package com.wipro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.wipro.entity.*;


@FeignClient("clientProduct")
public interface ProductProxy {
	
	@GetMapping("/product/products/{id}")
	public Product searchProduct(@PathVariable("id") Long id);
}
