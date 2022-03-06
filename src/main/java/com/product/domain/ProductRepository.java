package com.product.domain;

import java.util.Set;

public interface ProductRepository {

	public Product getProductById(String productId);
	
	public Set<String> getSimilarProducts(String productId);
}
