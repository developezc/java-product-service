package com.product.application;

import java.util.Set;

import com.product.domain.Product;

public interface ProductServicePort {

	public  Set<Product> getProductSimilar(String productId);
}
