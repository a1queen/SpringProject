package com.example.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.NewOrder;

@FeignClient(name = "orders", url = "http://localhost:8080")
public interface NewOrderProxy {

	@GetMapping("/order")
	List<NewOrder> getOrders();

	@PostMapping("/order")
	void addOrder(@RequestBody NewOrder products);

}
