package com.product.infraestructure.persistence;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.domain.Product;

@FeignClient(name = "ProductFeingRepository", url = "${openfeign.product-service-url}")
public interface ProductFeingRepositoryPort {

	@GetMapping("/{productId}/similarids")
	public Set<String> getSimilarIds(@PathVariable("productId") String productId);
	
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable("productId") String productId);
	
}
