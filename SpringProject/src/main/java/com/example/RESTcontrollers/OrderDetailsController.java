package com.example.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.OrderDetails;
import com.example.repositories.OrderDetailsRepository;

@RestController
@RequestMapping("/orderdetails")
@ResponseBody
public class OrderDetailsController {

	@Autowired
	OrderDetailsRepository repository;

	@GetMapping
	public ResponseEntity<List<OrderDetails>> getOrderDetails() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.findAll());
	}

	@PostMapping
	public ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {

		repository.save(orderDetails);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderDetails);
	}

}
