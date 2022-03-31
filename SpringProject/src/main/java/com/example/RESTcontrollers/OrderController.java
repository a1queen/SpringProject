package com.example.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.NewOrder;
import com.example.repositories.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderRepository repository;

	@GetMapping
	public ResponseEntity<List<NewOrder>> getOrders() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.findAll());
	}

	@PostMapping
	public ResponseEntity<NewOrder> addOrder(@RequestBody NewOrder added) {
		repository.save(added);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(added);
	}

}
