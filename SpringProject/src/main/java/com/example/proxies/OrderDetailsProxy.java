package com.example.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.OrderDetails;

@FeignClient(name = "details", url = "http://localhost:8080")
public interface OrderDetailsProxy {
	@GetMapping("/orderdetails")
	List<OrderDetails> getOrderDetails();

	@PostMapping("/orderdetails")
	void addOrderDetails(@RequestBody OrderDetails orderDetails);

}
