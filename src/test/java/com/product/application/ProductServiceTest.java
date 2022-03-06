package com.product.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.product.domain.Product;
import com.product.domain.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductServiceAdapter underTest;

	@Test
	public void getProductSimilar() {

		Product product = Product.builder().id("1").name("Product").availability(true).price(BigDecimal.ONE).build();

		Set<String> setProduct = Stream.of(product.getId()).collect(Collectors.toSet());

		when(productRepository.getSimilarProducts(Mockito.anyString())).thenReturn(setProduct);
		when(productRepository.getProductById(Mockito.anyString())).thenReturn(product);

		Set<Product> result = underTest.getProductSimilar("1");

		assertEquals(result.stream().findFirst().get(), product);
	}

	@Test
	public void doesntGetProductSimilar() {

		when(productRepository.getSimilarProducts(Mockito.anyString())).thenReturn(Collections.emptySet());

		Set<Product> result = underTest.getProductSimilar("1");

		assertEquals(result.isEmpty(), true);
	}

}
