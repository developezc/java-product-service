package com.product.infraestructure.api;

import java.util.Collections;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.application.ProductServicePort;
import com.product.domain.Product;

@RestController
@Valid
public class ProductController {

	@Autowired
	private ProductServicePort productService;

	/**
	 * GET /product/{productId}/similar : Similar products
	 *
	 * @param productId (required)
	 * @return OK (status code 200) or Product Not found (status code 404)
	 */
	@GetMapping(value = "/product/{productId}/similar", produces = { "application/json" })
	public ResponseEntity<Set<Product>> getProductSimilar(@PathVariable("productId")@NotBlank String productId) {

		Set<Product> result = productService.getProductSimilar(productId);
		
		if(result.isEmpty())
			return new ResponseEntity<Set<Product>>(Collections.emptySet(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<Set<Product>>(result, HttpStatus.OK);
	}
}
