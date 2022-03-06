package com.product.infraestructure.persistence;

import java.util.Collections;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.domain.Product;
import com.product.domain.ProductRepository;
import feign.FeignException;

@Repository
public class ProductFeingRepositoryAdapter implements ProductRepository {

	@Autowired
	private ProductFeingRepositoryPort productFeingRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductFeingRepositoryAdapter.class);

	@Override
	public Product getProductById(String productId) {

		try {
			return productFeingRepository.getProduct(productId);

		} catch (FeignException e) {
			LOGGER.error("No se ha podido obtener el producto con id: " + productId);
			return Product.NOT_FOUND;
		}
	}

	@Override
	public Set<String> getSimilarProducts(String productId) {

		try {
			return productFeingRepository.getSimilarIds(productId);
		} catch (FeignException e) {
			LOGGER.error("No se ha podido obtener los productos similares del producto: " + productId);
			return Collections.emptySet();
		}

	}
}
