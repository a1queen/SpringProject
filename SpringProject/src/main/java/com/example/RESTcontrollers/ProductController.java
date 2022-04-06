package com.example.RESTcontrollers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.json.simple.JSONObject;
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
import com.example.model.Product.Type;
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
	public ResponseEntity<Product> addProduct(@RequestBody JSONObject object) {
		Product added = new Product(object.get("name").toString(), convert(object.get("type")),
				new BigDecimal(object.get("price").toString()));
		repository.save(added);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(added);
	}

	public com.example.model.Product.Type convert(Object source) {
		return Product.Type.valueOf(source.toString().toUpperCase());
	}

}
