package com.example.proxies;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Product;

@FeignClient(name = "products", url = "http://localhost:8080")

public interface ProductsProxy {

	@GetMapping("/product")
	List<Product> getProducts();

	@PostMapping("/product")
	void addProduct(@RequestBody JSONObject jobject);

}
