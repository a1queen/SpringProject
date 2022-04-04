package com.example.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Company;
import com.example.repositories.CompanyRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyRepository repository;

	@GetMapping
	public ResponseEntity<List<Company>> getCompanies() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.findAll());
	}

	@PostMapping
	public ResponseEntity<String> addCompanyDetails(@RequestBody(required = true) String name) {
		repository.save(new Company(name));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(name);
	}

}
