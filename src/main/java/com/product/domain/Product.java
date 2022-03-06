package com.product.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private String id;

	private String name;

	private BigDecimal price;

	private Boolean availability;
	
	public static Product NOT_FOUND = Product.builder().id("-1")
			.name("Product Not Found")
			.availability(false)
			.price(BigDecimal.ZERO)
			.build();


}
