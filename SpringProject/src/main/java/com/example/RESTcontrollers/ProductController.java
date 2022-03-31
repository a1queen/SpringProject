package com.example.RESTcontrollers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.repositories.ProductRepository;

@CrossOrigin("*")
@RestController

@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository repository;

	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.findAll());
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestParam(required = true) String name,
			@RequestBody Product.Type type) {
		Product added = new Product(name, type, new BigDecimal(12));
		repository.save(added);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(added);

	}

	public com.example.model.Product.Type convert(String source) {
		return Product.Type.valueOf(source.toUpperCase());
	}

}
