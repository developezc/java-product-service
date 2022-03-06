package com.product.application;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.domain.Product;
import com.product.domain.ProductRepository;

@Service
public class ProductServiceAdapter implements ProductServicePort {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Set<Product> getProductSimilar(String productId) {

		Set<String> similarsIds = productRepository.getSimilarProducts(productId);

		return similarsIds.stream()
				.map(x -> productRepository.getProductById(x))
				.filter(x -> x.getId() != "-1")
				.collect(Collectors.toSet());
	}
}
